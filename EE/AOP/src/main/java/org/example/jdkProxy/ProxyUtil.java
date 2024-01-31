package org.example.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star createProxy(Star star) {
        Star starProxy = (Star) Proxy.newProxyInstance(star.getClass().getClassLoader(), new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("准备场地...");
                        } else if (method.getName().equals("dance")) {
                            System.out.println("准备舞台...");
                        }
                        return method.invoke(star, args);
                    }
                });

        return starProxy;
    }
}
