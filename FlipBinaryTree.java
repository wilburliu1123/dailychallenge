class FlipBinaryTree {
  List<Integer> list = new ArrayList<>();
  int idx = 0;
  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

    return dfs(root, voyage) ? list : Arrays.asList(-1);
  }
  boolean dfs(TreeNode root, int[] voyage) {
    if (root == null) return true;
    if (root.val != voyage[idx++]) return false;
    if (root.left != null && root.left.val != voyage[idx]) {
      list.add(root.val);
      return dfs(root.right, voyage) && dfs(root.left, voyage);
    }
    return dfs(root.left, voyage) && dfs(root.right, voyage);
  }
}