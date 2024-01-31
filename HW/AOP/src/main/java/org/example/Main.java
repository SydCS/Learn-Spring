package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("org.example")
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        Calculator c = ctx.getBean(Calculator.class);
        System.out.println(c.getClass().getName());

        int result = c.div(2, 0);
        System.out.println(result);

        ctx.close();
    }
}