package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class Aspects {
    @Around("@annotation(org.example.TimeRecording)")
    @Order(2) // TODO 为什么控制不了顺序
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("FirstAspect - TimeRecording");

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // 执行目标方法
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("方法执行时间：" + executionTime + "ms");
        return result;
    }

    @Around("@annotation(retry)")
    @Order(1)
    public Object retryOnFailure(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        System.out.println("SecondAspect - Retry");

        int numAttempts = 0;
        Throwable lastException;
        int max = retry.times();

        do {
            try {
                return joinPoint.proceed(); // 执行目标方法
            } catch (Throwable ex) {
                numAttempts++;
                System.out.println(numAttempts + " " + ex.getClass().getName());
                lastException = ex;
            }
        } while (numAttempts <= max);

        throw lastException;
    }
}
