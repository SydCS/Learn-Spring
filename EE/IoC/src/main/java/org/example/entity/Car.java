package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Component("car")
//@Scope("singleton")
//@Lazy(true)
public class Car
{
//    @Autowired
    IEngine engine;

    IBrake brake;

    // 默认调无参
    public Car() {
    }

    // 若想指定有参, @Autowired
    @Autowired
    public Car(IEngine engine, IBrake brake) {
        this.engine = engine;
        this.brake = brake;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", brake=" + brake +
                '}';
    }
}
