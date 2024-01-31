package org.example.entity.factory;

import org.example.entity.Fruit;

// 工厂方法
public interface FruitFactory {
    public Fruit getFruit(String name);
}
