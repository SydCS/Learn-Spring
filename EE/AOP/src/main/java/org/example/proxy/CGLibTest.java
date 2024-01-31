package org.example.proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibTest {
    public void test() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./cglibgen");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLibTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });

        CGLibTest proxy = (CGLibTest) enhancer.create();
        proxy.test();

        System.out.println(proxy.getClass().getName());
        System.out.println(proxy.getClass().getSuperclass().getName());
    }
}
