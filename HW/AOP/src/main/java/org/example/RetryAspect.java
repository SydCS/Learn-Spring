package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class RetryAspect {
    @Around("@annotation(retry)")
    public Object retryOnFailure(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        System.out.println("SecondAspect - Retry");

        int attempt = 0;
        Throwable lastException;
        int maxAttempts = retry.times();

        do {
            try {
                return joinPoint.proceed(); // 执行目标方法
            } catch (Throwable ex) {
                System.out.println("Attempt " + attempt + " failed: " + ex.getMessage());
                attempt++;
                lastException = ex;
            }
        } while (attempt <= maxAttempts);

        throw lastException;
    }
}
