package org.example;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    // 业务逻辑方法
    @Retry(times = 3)
    @TimeRecording
    public int div(int i, int j) throws InterruptedException {
        System.out.println("in div method, i = " + i + ", j = " + j);
        Thread.sleep(1000L);
        return i / j;
    }
}