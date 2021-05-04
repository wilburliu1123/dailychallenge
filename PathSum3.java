class PathSum3 {
  Map<Integer, Integer> map;
  int res = 0;
  int targetSum;
  public int pathSum(TreeNode root, int target) {
    map = new HashMap<>();
    targetSum = target;
    helper(root, 0);
    return res;
  }
  void helper(TreeNode root, int sum) {
    if (root == null) return;
    sum += root.val;
    if (sum == targetSum) {
      res++;
    }
    res += map.getOrDefault(sum - targetSum, 0);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    if (root.left != null) {
      helper(root.left, sum);
    }
    if (root.right != null) {
      helper(root.right, sum);
    }
    map.put(sum, map.get(sum) - 1);
  }
}