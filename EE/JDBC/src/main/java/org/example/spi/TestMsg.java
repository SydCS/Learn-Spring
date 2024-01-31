package org.example.spi;

import org.junit.Test;

public class TestMsg {
    @Test
    public void test() throws ClassNotFoundException {
        Class.forName("org.example.spi.MyMsg");
        Class.forName("org.example.spi.YourMsg");
        IMsg my = MsgManager.getMsgConnection("my");
        IMsg your = MsgManager.getMsgConnection("your");
        my.send("你好，世界");
        your.send("你好，世界");
    }
}
