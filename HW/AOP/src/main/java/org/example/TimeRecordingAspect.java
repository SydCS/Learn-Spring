package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class TimeRecordingAspect {
    @Around("@annotation(org.example.TimeRecording)")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("FirstAspect - TimeRecording");

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // 执行目标方法
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("方法执行时间：" + executionTime + "ms");
        return result;
    }
}
