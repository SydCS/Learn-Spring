package org.example.spi;


public class MyMsg implements IMsg {

    static {
        MsgManager.register("my", MyMsg.class);
    }

    public void send(String msg) {
        System.out.println("[通过MyMsg实现加载]" + msg);
    }
}