package org.example;

import org.example.entity.Fruit;
import org.example.entity.factory.FruitFactory;
import org.example.entity.factory.FruitFactoryBuilder;
import org.example.entity.factory.SimpleFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.entity")
public class Main {
    public static void main(String[] args) throws Exception {
//        Fruit fruit = SimpleFactory.getFruit("apple");

        FruitFactory fruitFactory = FruitFactoryBuilder.getFruitFactory();
        Fruit fruit = fruitFactory.getFruit("apple");
        System.out.println(fruit);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        FruitFactoryBuilder fruitFactoryBuilder = (FruitFactoryBuilder) context.getBean("fruitFactoryBuilder");
//        System.out.println(fruitFactoryBuilder.getFruitFactory().getFruit("apple"));
    }
}