package org.example.entity.factory;

import org.example.entity.Apple;
import org.example.entity.Fruit;
import org.example.entity.Orange;

public class SimpleFactory {
    // 简单工厂
    // 问题：违反 open-close principle
    public static Fruit getFruit(String name) {
        if ("apple".equals(name)) {
            return new Apple();
        } else if ("orange".equals(name)) {
            return new Orange();
        } else {
            return null;
        }

    }
}
