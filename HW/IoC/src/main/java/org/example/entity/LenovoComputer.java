package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lenovo")
public class LenovoComputer extends Computer {
    // 依赖注入:

    // 1. @Autowired

    // 2. Constructor: 默认无参; 想选有参 - @Autowired
//    public LenovoComputer() {
//        super();
//    }

    // 按类型; 按名字 @Qualifier() or 变量名
    @Autowired
    public LenovoComputer(@Qualifier("dell") Displayer displayer, @Qualifier("hp") Printer printer) {
        this.displayer = displayer;
        this.printer = printer;
    }

//    @Autowired
//    public LenovoComputer(Displayer dell, Printer hp) {
//        this.displayer = dell;
//        this.printer = hp;
//    }

    // 3. Setters
    @Autowired
    public void setDisplayer(Displayer displayer) {
        this.displayer = displayer;
    }

    @Autowired
    public void setPrinter(Printer hp) {
        this.printer = hp;
    }
}