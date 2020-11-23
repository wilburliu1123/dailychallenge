int inIndex, postIndex;
public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIndex = inorder.length - 1;
        postIndex = postorder.length - 1;
        return buildTree(inorder, postorder, null);
}
private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode root) {
        if (postIndex < 0) {
            return null;
        }
        TreeNode n = new TreeNode(postorder[postIndex--]);
        // find rightest node
        // build the right subtree
        if (n.val != inorder[inIndex]) {
            n.right = buildTree(inorder, postorder, n);
        }
        inIndex--;
        if (root == null || root.val != inorder[inIndex]) {
            n.left = buildTree(inorder, postorder, root);
        }
        return n;
}