package leetcode.tree;

public class LevelVisitBinaryTree {
    public static int test() {
        int i = 0;
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            System.out.println("finally i =" + i);
            i+=10;
            System.out.println("finally ii="+i);
            return i;
        }
    }

    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }
}
