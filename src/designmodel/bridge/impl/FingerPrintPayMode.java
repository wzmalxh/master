package designmodel.bridge.impl;

import designmodel.bridge.IPayMode;

public class FingerPrintPayMode implements IPayMode {
    @Override
    public boolean security(String uuid) {
        System.out.println("指纹支付");
        return true;
    }
}
