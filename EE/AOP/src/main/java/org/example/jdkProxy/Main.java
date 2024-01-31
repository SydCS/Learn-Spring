package org.example.jdkProxy;

public class Main {
    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Star starProxy = ProxyUtil.createProxy(new BigStar("杨超越"));
        System.out.println(starProxy.sing("卡路里"));
        starProxy.dance();
    }
}
