class LowestCommonancestor3 {
  public Node lowestCommonAncestor(Node p, Node q) {
    Node root = p;
    while (root.parent != null) {
      root = root.parent;
    }
    return LCA(root, p, q);
  }
  private Node LCA(Node root, Node p, Node q) {
    if (root == null) return root;
    Node left = LCA(root.left, p, q);
    Node right = LCA(root.right, p, q);
    if (root == p) return root;
    if (root == q) return root;
    if (left != null && right != null) return root;
    return left == null ? right : left;
  }
}