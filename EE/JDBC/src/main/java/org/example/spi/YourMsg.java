package org.example.spi;


public class YourMsg implements IMsg {

    static {
        MsgManager.register("your", YourMsg.class);
    }

    public void send(String msg) {
        System.out.println("[通过YourMsg实现加载]" + msg);
    }
}