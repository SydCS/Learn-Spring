package org.example.entity.factory;

import org.example.entity.Fruit;
import org.example.entity.Orange;

public class OrangeFactory implements FruitFactory {
    @Override
    public Fruit getFruit(String name) {
        return new Orange();
    }
}
