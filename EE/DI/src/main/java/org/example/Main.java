package org.example;

import org.example.entity.Car;
import org.example.entity.Door;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan("org.example.entity")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        System.out.println(context.getBeanDefinition("car"));

        Car car = (Car) context.getBean("car");
        System.out.println(car);

        System.out.println("======doorList========");
        for (Door door : car.doorList) {
            System.out.println(door);
        }
        System.out.println("======doorSet========");
        for (Door door : car.doorSet) {
            System.out.println(door);
        }
        System.out.println("======doorArray========");
        for (Door door : car.doorArray) {
            System.out.println(door);
        }
        System.out.println("=======doorMap=======");
        for (Map.Entry<String, Door> entry : car.doorMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}