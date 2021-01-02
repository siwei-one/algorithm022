public class 从前序与中序遍历序列构造二叉树 {
    private int in = 0;
    private int pre = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // pre走到preorder末尾
        if (pre == preorder.length) return null;
        // in指针走到了停止点
        if (inorder[in] == stop) {
            // stop点废弃了，in推进一位
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        // 左子树的停止点是当前的根节点的值
        node.right = build(preorder, inorder, stop);
        // 右子树的停止点是当前树的停止点
        return node;
    }
}