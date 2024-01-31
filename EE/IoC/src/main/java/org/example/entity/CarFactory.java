package org.example.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CarFactory {
    @Bean
    public Car getCar() {
        return new Car();
    }
}
