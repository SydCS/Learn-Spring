package org.example.entity;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CarFactoryBean extends AbstractFactoryBean<Car> {

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    protected Car createInstance() throws Exception {
        return new Car();
    }
}