package org.example.usage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("--------------------------------------------------");

        System.out.println(((JdbcTemplate) context.getBean("jdbcTemplate")).getDataSource());

        System.out.println(context.getBean(MyService.class).someDatabaseOperation());

        context.close();
    }
}