package org.example.template;


public class TestPay {
    public static void main(String[] args) {
        System.out.println("---网银 start");
        BasePay pay1 = new EBankPay();
        pay1.mobilePay();
        System.out.println("---网银 end");

        System.out.println("---支付宝 start");
        BasePay pay2 = new AliPay();
        pay2.mobilePay();
        System.out.println("---支付宝 end");
    }
}