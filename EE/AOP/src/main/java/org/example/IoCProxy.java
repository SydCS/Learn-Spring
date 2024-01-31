package org.example;

import org.example.entity.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO 什么意思？
@Configuration(proxyBeanMethods = true)
//@ComponentScan("org.example.entity")
public class IoCProxy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(IoCProxy.class);
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("--------------------------");

        System.out.println(ctx.getBean("ioCProxy").getClass()); // ?
        IoCProxy iocProxy = (IoCProxy) ctx.getBean("ioCProxy");
        System.out.println(iocProxy.getCar() == iocProxy.getCar());

        IoCProxy iocProxy1 = new IoCProxy();
        System.out.println(iocProxy1.getCar() == iocProxy1.getCar());
    }

    @Bean
    public Car getCar() {
        return new Car();
    }
}
