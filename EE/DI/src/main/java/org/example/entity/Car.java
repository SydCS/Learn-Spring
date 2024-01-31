package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@PropertySource("classpath:app.properties")
public class Car {

    //    @Value("Audi")
    @Value("${brand}")
    public String brand;

    @Value("60")
    public int price;

    @Autowired
    public Door[] doorArray;

    @Autowired
    public List<Door> doorList;

    @Autowired
    public Set<Door> doorSet;

    @Autowired
    public Map<String, Door> doorMap;


//    @Resource(name = "myengine")
    @Autowired
    Engine engine;

    @Autowired
    public Car(@Value("BMW") String brand, @Value("123") int price, Engine engine) {
        this.brand = brand;
        this.price = price;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                '}';
    }
}

