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
// solution using bit manipulation
class LowestCommonAncestor {
  TreeNode res = null;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root, p, q);
    return res;
  }
  private int dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return 0;
    int state = dfs(root.left, p, q);
    if (root.val == p.val) state |= 1;
    if (root.val == q.val) state |= 2;
    state |= dfs(root.right, p, q);
    if (state == 3 && res == null) res = root;
    return state;
  }
}