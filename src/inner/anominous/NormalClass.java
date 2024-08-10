package inner.anominous;

public class NormalClass {
    private String normal;

    public NormalClass(String n ){
        this.normal = n;
    }

    public String callMethod(CallBackInterface callBackInterface){
        Integer value = 123;
        callBackInterface.interfaceStart(value);
        return "内部类结果——"+ value;
    }

    public static void main(String[] args) {
        NormalClass n = new NormalClass("NormalTest 03");
         n.callMethod(new CallBackInterface() {
            @Override
            public void interfaceStart(Integer integer) {
                System.out.println("Test anominous class: "+ integer);
            }
        });


        n.callMethod(ele -> {
            System.out.println("Test anominous class lambda: "+ ele);
        });
    }
}
