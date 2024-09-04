package leetcode.tree;

import java.util.*;

public class BuildTreeDemo2 {
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
    static int[] pre;
    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int []preOrder, int []inOrder){
        int ps = 0;
        int pe = preOrder.length;
        int is = 0;
        int ie = inOrder.length;
        for(int i= is; i< ie; i++){
            map.put(inOrder[i],i);
        }
        pre = preOrder;
        return dfsBuildTree(ps,pe,is,ie);
    }

    public static TreeNode dfsBuildTree(int ps,int pe,int is,int ie){
        if(ps > pe || is > ie){
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        int val = pre[ps];
        int middle = map.get(val);
        root.left = dfsBuildTree(ps+1,ps+middle-is-1,is,middle -1);
        root.right = dfsBuildTree(ps+middle-is,pe,middle+1, ie);
        return root;
    }

    public static void main(String[] args) {
        int []inOrder = {1,2,4,5,3};
        int []postOrder = {4,2,5,1,3};
        TreeNode root = buildTree(inOrder,postOrder);
        System.out.println(root.val);

    }

    public static List<Integer> visit(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return  result;
        }
        queue.offer(root);
        int size =1 ;
        while(!queue.isEmpty()) {
            int i= 0;
            while(i < size && !queue.isEmpty()){
                TreeNode tr = queue.poll();
                i++;
                if(tr == null){
                    break;
                }
                if(i == size) {
                    result.add(tr.val);
                }
                if(tr.left != null){
                    queue.offer(tr.left);
                }
                if(tr.right != null) {
                    queue.offer(tr.right);
                }
            }
            size = queue.size();
        }
        return result;
    }
}
