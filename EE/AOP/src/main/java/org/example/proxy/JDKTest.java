package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class JDKTest {
    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        final List list = new ArrayList();
        list.add("abc");

        List listProxy = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                new Class[]{List.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("size")) {
                            System.out.println("Hi there ...");
                        }
                        return method.invoke(list, args);
                    }
                });

        System.out.println(listProxy.size());

        System.out.println("----------------------------------");
        System.out.println(list.getClass().getName());
        System.out.println(listProxy.getClass().getName());
        for (Class<?> i : listProxy.getClass().getInterfaces()) {
            System.out.println(i.getName());
        }
    }
}