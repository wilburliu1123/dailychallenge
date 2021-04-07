class ConstructBSTfromInorder {
  int preIdx = 0, inIdx = 0;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, inorder, null);
  }
  TreeNode build(int[] pre, int[] in, TreeNode root) {
    if (preIdx == pre.length) {
      return root;
    }
    TreeNode n = new TreeNode(pre[preIdx++]);
    if (n.val != in[inIdx]) {
      n.left = build(pre, in, n);
    }
    inIdx++;
    if (root == null || root.val != in[inIdx]) {
      n.right = build(pre, in, root);
    }
    return n;
  }
}