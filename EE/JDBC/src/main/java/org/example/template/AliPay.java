package org.example.template;

public class AliPay extends AbstractBasePay {
    @Override
    void channelPay() {
        System.out.println("支付宝");
    }
}
