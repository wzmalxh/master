package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    class TreeNode{
        private TreeNode left;
        private TreeNode right;

        private int val;

    }

    public boolean isCompleteTree (TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return true;
        }
        boolean left = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tr = queue.poll();
            if(tr == null){
                left = false;
            }else{
                if(!left){
                    //如果左边是null的情况，右边还有值，就说明不对
                    return false;
                }
                queue.offer(tr.left);
                queue.offer(tr.right);
            }

        }
        return true;
    }
}
