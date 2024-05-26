package leetcode.tree;

public class MirrorTree {
    /**
     * 二叉树的镜像
     */

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return pRoot;
        }
        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);
        //交换
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;

    }
}
