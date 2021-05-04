class PathSum2 {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> pathSum(TreeNode root, int target) {
    helper(root, new ArrayList<>(), target);
    return res;
  }
  void helper(TreeNode root, List<Integer> list, int target) {
    if (root == null && target != 0) {
      return;
    } else if (root == null && target == 0) {
      return;
    } else if (root.left == null && root.right == null && target - root.val == 0) {
      list.add(root.val);
      res.add(new ArrayList<>(list));
      return;
    }
    list.add(root.val);
    if (root.left != null) {
      helper(root.left, list, target - root.val);
      list.remove(list.size() - 1);
    }
    if (root.right != null) {
      helper(root.right, list, target - root.val);
      list.remove(list.size() - 1);
    }
  }
}