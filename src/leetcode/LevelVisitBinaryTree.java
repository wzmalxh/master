package leetcode;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelVisitBinaryTree {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        int size = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for(int i= size ; i >=0 ; i--){
                TreeNode r = queue.peek();
                queue.pop();
                tmp.add(r.val);
                if(r.left != null){
                    queue.offer(r.left);
                }
                if(r.right != null){
                    queue.offer(r.right);
                }
            }
            result.add(tmp);
        }

        return result;
    }
}
