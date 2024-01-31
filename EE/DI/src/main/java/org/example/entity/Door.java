package org.example.entity;

import org.springframework.stereotype.Component;

public class Door {
    String name;

    public Door(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Door{" +
                "name='" + name + '\'' +
                '}';
    }
}
