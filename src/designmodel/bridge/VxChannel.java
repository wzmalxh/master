package designmodel.bridge;

public class VxChannel extends Channel{

    public VxChannel(IPayMode payMode){
        super();
    }

    @Override
    public String transfer(String uid, int amount) {
        System.out.println("微信支付");
        return null;
    }
}
