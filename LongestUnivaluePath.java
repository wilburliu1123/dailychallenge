class LongestUnivaluePath {
  int res;
  public int longestUnivaluePath(TreeNode root) {
    res = 0;
    helper(root);
    return res;
  }
  int helper(TreeNode root) {
    if (root == null) return 0;
    int left = helper(root.left);
    int right = helper(root.right);
    int leftLength = 0, rightLength = 0;
    if (root.left != null && root.left.val == root.val) {
      leftLength += left + 1;
    }
    if (root.right != null && root.right.val == root.val) {
      rightLength += right + 1;
    }
    res = Math.max(res, leftLength + rightLength);
    return Math.max(leftLength, rightLength);
  }
}