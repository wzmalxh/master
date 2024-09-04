package leetcode.tree;

import java.util.HashMap;

public class BuildTreeDemo {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int[] post;
    private static HashMap<Integer, Integer> map = new HashMap<>();
    public  static TreeNode buildTree(int[] inorder, int[] postorder) {
        int is = 0;
        int ie = inorder.length - 1;
        int ps = 0;
        int pe = postorder.length - 1;
        //首先构建hashMap，存放各个元素
        for (int i = is; i <= ie; i++) {
            map.put(inorder[i], i);
        }
        post = postorder;
        //找到最后一个元素
        return dfsBuild(is, ie, ps, pe);
    }

    public static TreeNode dfsBuild(int iBegin, int iEnd, int pBegin, int pEnd) {
        if (iEnd < iBegin || pEnd < pBegin) {
            return null;
        }
        int rootVal = post[pEnd];
        TreeNode root = new TreeNode(rootVal);
        System.out.println("root.val is :"+rootVal);
        if(map.get(rootVal) == null) {
            return null;
        }
        int middle = map.get(rootVal);
        root.left = dfsBuild(iBegin, middle - 1, pBegin, pBegin + (middle - iBegin) - 1);
        root.right = dfsBuild(middle + 1, iEnd, pBegin + (middle - iBegin), pEnd - 1);
        return root;
    }


    public static void main(String[] args) {
        int []inOrder = {9,3,15,20,7};
        int []postOrder = {9,15,7,20,3};
        TreeNode root = buildTree(inOrder,postOrder);
        System.out.println(root.val);

    }
}
