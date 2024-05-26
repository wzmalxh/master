package javatest;

public class ZhuanZhuan {
    public void save1(){
        this.doSave();
    }
    public void doSave(){
        this.save();
    }

    private void save() {
        System.out.println("save success");
    }
}
