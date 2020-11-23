class buildTree_postorder {
    int inIndex, postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIndex = inorder.length - 1;
        postIndex = postorder.length - 1;
        return postBuildTree(inorder, postorder, null);
    }
    private TreeNode postBuildTree(int[] inorder, int[] postorder, TreeNode root) {
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
}
class buildTree_preorder {
    int preIndex, inIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inIndex = 0;
        return buildTree(preorder, inorder, null);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, TreeNode root) {
        if (preIndex > preorder.length - 1) {
            return null;
        }
        TreeNode n = new TreeNode(preorder[preIndex++]);
        if (n.val != inorder[inIndex]) {
            n.left = buildTree(preorder, inorder, n);
        }
        inIndex++;
        if (root == null || root.val != inorder[inIndex]) {
            n.right = buildTree(preorder, inorder, root);
        }
        return n;
    }
}
class buildTree_prePostorder {
    int preIndex, postIndex;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        preIndex = 0; postIndex = 0;
        return buildTree(pre, post, null);
    }
    private TreeNode buildTree(int[] pre, int[] post, TreeNode root) {
        if (preIndex > pre.length - 1) {
            return null;
        }
        TreeNode n = new TreeNode(pre[preIndex++]);
        if (n.val != post[postIndex]) {
            n.left = buildTree(pre, post, n);
        }
        if (n.val != post[postIndex]) {
            n.right = buildTree(pre, post, n);
        }
        postIndex++;
        return n;
    }
}