class RecoverBinaryTree {
  int idx = 0;
  public TreeNode recoverFromPreorder(String S) {
    return dfs(S, 0);
  }
  TreeNode dfs(String s, int level) {
    int dash = 0;
    while (idx + dash < s.length() && s.charAt(idx + dash) == '-') {
      dash++;
    }
    if (dash != level) return null;
    int next = idx + dash;
    while (next < s.length() && s.charAt(next) != '-')
      next++;
    int val = Integer.parseInt(s.substring(idx + dash, next));
    idx = next;
    TreeNode root = new TreeNode(val);
    root.left = dfs(s, level + 1);
    root.right = dfs(s, level + 1);
    return root;
  }
}