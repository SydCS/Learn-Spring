package org.example.template;

public class EBankPay extends AbstractBasePay {

    @Override
    void channelPay() {
        System.out.println("网银");
    }

    @Override
    boolean isCheckAuth() {
        return false;
    }
}
