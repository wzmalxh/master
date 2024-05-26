package designmodel.bridge;

import designmodel.bridge.impl.FingerPrintPayMode;

public class TestBridgeDemo {
    public static void main(String[] args) {
        FingerPrintPayMode mode = new FingerPrintPayMode();
        VxChannel vx  = new VxChannel(mode);

        vx.transfer("WangYu",60);
    }
}
