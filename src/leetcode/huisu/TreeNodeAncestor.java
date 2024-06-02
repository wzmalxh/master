package leetcode.huisu;

public class TreeNodeAncestor {
    class TreeNode {
        private TreeNode left;
        private TreeNode right;

        int val;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode nearestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = nearestCommonAncestor(root.left, p, q);
        TreeNode right = nearestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (right != null && left != null) {
            return root;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] prices = {2, 3, 6, 1, 7, 9, 13};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int k = 1; k < prices.length; k++) {
            if (prices[k - 1] < prices[k]){
                result += (prices[k] - prices[k-1]);
            }
        }

        return result;
    }
}
