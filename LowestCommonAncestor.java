class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (root.val == p.val) return root;
    if (root.val == q.val) return root;
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
}