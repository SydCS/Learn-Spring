package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 日志切面类
@Aspect
public class LogAspects {
    @Pointcut("execution(public int org.example.aop.Calculator.*(..))")
    public void pointCut() {
    }

    // @before 表示在目标方法执行前切入, 并指定在哪个方法前切入
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        int i = (int) joinPoint.getArgs()[0];
        int j = (int) joinPoint.getArgs()[1];

        System.out.printf("除法运行... 参数列表是: {%s, %s}%n", i, j);
    }

    @AfterReturning(value = "pointCut()", returning = "retVal")
    public void logReturn(Object retVal) {
        System.out.printf("除法正常返回...... 运行结果是: {%d}%n", retVal);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Exception e) {
        System.out.printf("运行异常...... 异常信息是: {%s}%n", e.getMessage());
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束......");
    }

    @Around("pointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("@Around: 执行目标方法之前...");
        Object obj = proceedingJoinPoint.proceed(); //相当于开始调div地
        System.out.println("@Around: 执行目标方法之后......");
        return obj;
    }
}