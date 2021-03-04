class FinaDistance {
  public int findDistance(TreeNode root, int p, int q) {
    TreeNode lca = LCA(root, p, q);
    return distance(lca, p, 0) + distance(lca, q, 0);
  }
  private int distance(TreeNode root, int target, int path) {
    if (root == null) return -1;
    if (root.val == target) {
      return path;
    }
    int res = distance(root.left, target, path + 1);
    if (res == -1) {
      res = distance(root.right, target, path + 1);
    }
    return res;
  }
  private TreeNode LCA(TreeNode root, int p, int q) {
    if (root == null) return root;
    TreeNode left = LCA(root.left, p, q);
    TreeNode right = LCA(root.right, p, q);
    if (root.val == p) {
      return root;
    }
    if (root.val == q) {
      return root;
    }
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
}