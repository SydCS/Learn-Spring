package org.example.entity;


public class Computer {
//    @Autowired
//    @Qualifier("dell")
    Displayer displayer;

//    @Autowired
//    @Qualifier("hp")
    Printer printer;

    @Override
    public String toString() {
        return "Computer{" +
                "displayer=" + displayer +
                ", printer=" + printer +
                '}';
    }
}
