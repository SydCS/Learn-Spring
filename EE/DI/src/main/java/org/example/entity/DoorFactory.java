package org.example.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class DoorFactory {
    @Bean("door1")
    @Order(2)
    public Door getDoor1() {
        return new Door("door1");
    }

    @Bean("door2")
    @Order(1)
    public Door getDoor2() {
        return new Door("door2");
    }

    @Bean("door3")
    @Conditional(MyCondition.class) // 条件装配
    @Order(3)
    public Door getDoor3() {
        return new Door("door3");
    }
}

class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // context.getBeanFactory().
        System.out.println("=======here in my condition=======");
        System.out.println(context.getBeanFactory().getBeanDefinition("car"));
        System.out.println("=======here in my condition ends=======");

        return false;
    }
}





















