package javatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TreeMltiplyMaxDemo {

    static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int v){
            this.val = v;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootL = new TreeNode(2);
        TreeNode rooLL = new TreeNode(4);
        TreeNode rooLR = new TreeNode(6);
        rootL.left = rooLL;
        rootL.right = rooLR;
        TreeNode rooR = new TreeNode(3);
        TreeNode rooRL = new TreeNode(7);
        TreeNode rooRR = new TreeNode(9);
        root.left = rootL;
        root.right = rooR;
        rooR.left = rooRL;
        rooR.right = rooRR;
       // TreeNode result = findNearestCommonParent(root, rooRR, rooRL);
        List<TreeNode> rt = findMaxMultiNode(root);
        System.out.println(rt.size());
        System.out.println(rt.get(0).val+";" + rt.get(1));
       /* if(result != null){
            System.out.println(result.val);
        }*/
    }

    public static List<TreeNode> findMaxMultiNode(TreeNode tr){
        if(tr == null){
            return Collections.emptyList();
        }
        List<TreeNode> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        dfsTree(tr,list);
        List<TreeNode> res = findTop(list);
        return res;
    }

    private static List<TreeNode> findTop(List<TreeNode> list) {
        int maxV1 = Integer.MIN_VALUE;
        int maxV2 = Integer.MIN_VALUE;
        List<TreeNode> re = new ArrayList<>();
        TreeNode v1 = null;
        TreeNode v2 = null;
        if (list == null || list.size() < 2) {
            return Collections.emptyList();
        }
        for(TreeNode t: list){
            System.out.println(t.val);
        }
        for(TreeNode l: list){
            if(l.val > maxV1){
                maxV2 = maxV1;
                v1 = l;
                maxV1 = l.val;
            } else if(l.val > maxV2 && l.val != maxV1){
                maxV2 = l.val;
                v2 = l;
            }
        }
        re.add(v1);
        re.add(v2);
        return  re;
    }


    private static void dfsTree(TreeNode tr, List<TreeNode> list) {

        if(tr == null){
            return;
        }
        list.add(tr);
        if(tr.left != null){
            dfsTree(tr.left, list);
        }
        if(tr.right != null){
            dfsTree(tr.right, list);
        }
    }


    public static TreeNode findNearestCommonParent(TreeNode root,TreeNode left, TreeNode right){
        if(root == null){
            return  root;
        }
       return dfsParent(root, left,right);
    }

    private static TreeNode dfsParent(TreeNode root, TreeNode left, TreeNode right) {
        if(root == left || root == right || root == null){
            return root;
        }
        TreeNode l = dfsParent(root.left, left,right);
        TreeNode r = dfsParent(root.right,left,right);
        if(l != null && r != null){
            return root;
        }else{
            return l != null ? l : r;
        }

    }


}
