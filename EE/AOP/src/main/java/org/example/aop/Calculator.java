package org.example.aop;

public class Calculator implements ICalculator {
    // 业务逻辑方法
    public int div(int i, int j) {
        System.out.println("--------------------");
        return i / j;
    }
}