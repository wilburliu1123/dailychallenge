class LowestCommonAncestor4 {
  // brute force
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    TreeNode res = nodes[0];
    if (nodes.length == 1) return res;
    for (int i = 1; i < nodes.length; i++) {
      res = LCA(root, res, nodes[i]);
    }
    return res;
  }
  private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    TreeNode left = LCA(root.left, p, q);
    TreeNode right = LCA(root.right, p, q);
    if (root == p) return root;
    if (root == q) return root;
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
  // memo
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    Set<TreeNode> set = new HashSet<>();
    for (TreeNode node : nodes) set.add(node);
    return LCA(root, set);
  }
  private TreeNode LCA(TreeNode root, Set<TreeNode> set) {
    if (root == null) return root;
    if (set.contains(root)) return root;
    TreeNode left = LCA(root.left, set);
    TreeNode right = LCA(root.right, set);
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
}