public int CountNodes(TreeNode root) {
    int res = 0;
    if (root == null) return res;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        res++;
        if (cur.left != null) {
          q.add(cur.left);
        }
        if (cur.right != null) {
          q.add(cur.right);
        }
      }
    }
    return res;
}