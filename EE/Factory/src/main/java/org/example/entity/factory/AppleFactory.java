package org.example.entity.factory;

import org.example.entity.Apple;
import org.example.entity.Fruit;

public class AppleFactory implements FruitFactory{

    @Override
    public Fruit getFruit(String name) {
        return new Apple();
    }
}
