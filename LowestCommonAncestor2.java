class LowestCommonancestor2 {
  int state = 0;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode res = dfs(root, p, q);
    if (state == 3) return res;
    return null;
  }
  private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    TreeNode left = dfs(root.left, p, q);
    TreeNode right = dfs(root.right, p, q);
    if (root == p) {
      state |= 1;
      return root;
    } else if (root == q) {
      state |= 2;
      return root;
    }
    if (left != null && right != null && state == 3) return root;
    return left == null ? right : left;
  }
}