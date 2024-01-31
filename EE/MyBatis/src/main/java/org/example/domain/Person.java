package org.example.domain;

import lombok.Data;

@Data
public class Person {
    private Integer id;
    private String pname;
    private Integer age;
    private Address address;

    public Person(Integer id) {
        this.id = id;
    }
}
