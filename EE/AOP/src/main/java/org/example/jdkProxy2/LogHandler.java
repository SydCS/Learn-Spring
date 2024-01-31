package org.example.jdkProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LogHandler implements InvocationHandler {
    Object target;  // 被代理的对象，实际的方法执行者

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);  // 调用 target 的 method 方法
        after();
        return result;  // 返回方法的执行结果
    }

    // 调用 invoke 方法之前执行
    private void before() {
        System.out.printf("log start time [%s] %n", new Date());
    }

    // 调用 invoke 方法之后执行
    private void after() {
        System.out.printf("log end time [%s] %n", new Date());
    }
}