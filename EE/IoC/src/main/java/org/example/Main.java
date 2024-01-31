package org.example;

import org.example.entity.Car;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.example.entity")
@Configuration  // is-a @Component
public class Main {
    public static void main(String[] args) {
        // 创建容器
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // 可以自己注册 BeanDefinition, 走完整流程
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
        context.registerBeanDefinition("person", rootBeanDefinition);

        // 也可以自己注册 bean, 直接将完全初始化好的 bean 对象放到 BeanFactory 容器中
        context.getBeanFactory().registerSingleton("superman", new Person("superman", 100));
        System.out.println(context.getBean("superman"));

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        System.out.println(context.getBeanDefinition("car"));
        System.out.println(context.getBeanDefinition("getCar"));

        System.out.println("===========================");

        Car car = (Car) context.getBean("car");
//        Car car = context.getBean(Car.class);
        System.out.println(car);

        System.out.println(context.getBean("person"));

        System.out.println("===========================");

        System.out.println(context.getBean("carFactoryBean").getClass().getName());
        System.out.println(context.getBean("&carFactoryBean").getClass().getName());

        context.close();
    }
}

class Person {
    String name;
    int age;

    public Person() {
        System.out.println("Hello!");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}