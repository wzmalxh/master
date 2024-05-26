package javatest.yinyong;



public class TestValuePassDemo {
    private static int baseValue= 30;

    public static void updateBaseValue(int value){
        //说明这个方法里传入的是baseValue的副本，因此即使方法中改变了数值，对外也没有更改
        value = 2 * value;
    }

    public static void main(String[] args) {

        System.out.println("调用前baseValue的值："+baseValue);
        updateBaseValue(baseValue);
        System.out.println("调用后baseValue的值："+baseValue);

        SonDemo son = new SonDemo();
        son.setName("wangyu");
        System.out.println("子类获取父类的方法:"+ son.getName());
    }
}
