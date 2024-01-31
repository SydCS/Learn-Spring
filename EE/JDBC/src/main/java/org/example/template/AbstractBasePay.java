package org.example.template;

public abstract class AbstractBasePay implements BasePay {
    @Override
    public final void mobilePay() {
        // 钩子函数
        if (isCheckAuth()) {
            checkAuth();
        }
        checkParam();
        checkRisk();
        channelPay();
    }

    private void checkParam() {
        System.out.println("检查参数");
    }

    private void checkAuth() {
        System.out.println("支付权限校验");
    }

    private void checkRisk() {
        System.out.println("风控校验");
    }

    // 抽象方法 - 渠道支付
    abstract void channelPay();

    // 钩子函数：子类可以覆写，来选择是否开启支付权限校验 默认开启
    boolean isCheckAuth() {
        return true;
    }
}
