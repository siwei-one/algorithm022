public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件1
        if (root == null || root == p || root == q) {
            return root;
        }

        // 本层需要解决的事 + 向下递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 终止条件2
        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}