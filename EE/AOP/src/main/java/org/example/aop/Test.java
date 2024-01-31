package org.example.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        Calculator c = ctx.getBean(Calculator.class);   // 基于子类的动态代理 org.example.aop.Calculator$$SpringCGLIB$$0
//        ICalculator c = ctx.getBean(ICalculator.class);  // 基于接口的动态代理 jdk.proxy2.$Proxy21

        System.out.println(c.getClass().getName());

        System.out.println("---------------------------------");

        int result = c.div(4, 0);
        System.out.println(result);

        ctx.close();
    }
}