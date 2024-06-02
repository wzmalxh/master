package leetcode.tree;

import java.util.*;

public class ZSortedPrintBinaryTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> st = new LinkedList<>();

        if(root == null){
            return result;
        }
        st.offer(root);
        List<Integer> tmp = new ArrayList<>();
        while(!st.isEmpty()){
            int size = st.size();
            for(int i=0; i< size; i++){
                TreeNode tr = st.peek();
                st.poll();
                if(tr != null){
                    tmp.add(tr.val);
                    if(size % 2 == 1){
                        st.offer(tr.left);
                        st.offer(tr.right);
                    }else{
                        st.offer(tr.right);
                        st.offer(tr.left);
                    }
                }
            }
            result.add(tmp);

        }
        return result;
    }
}
