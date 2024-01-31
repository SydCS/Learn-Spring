package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    /**
     * control flow for di
     * 1.@Autowired on constructors and @Value @Autowired on parameters
     * 2.@Value @Autowired on attributes
     * 3.@Autowired on setters
     */
    @Value("250")
    int pid;

    @Value("lisi")
    String name;

    Address address;


    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    public void setName(@Value("wangwu") String name) {
        System.out.println("before setting: " + this.name);
        this.name = name;
        System.out.println("after setting: " + this.name);
    }

    public Person() {
        System.out.println("in person constructor person()");
    }

    @Autowired
    public Person(@Value("123") int pid, @Value("zhangsan") String pname) {
        System.out.println("in constructor Person(int pid, String pname)");
        this.pid = pid;
        this.name = pname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
