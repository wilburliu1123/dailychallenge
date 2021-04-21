class Node {
  Node left;
  Node right;
  int val;
  Set<String> set;
  Node (int val) {
    left = right = null;
    this.val = val;
    set = new HashSet<>();
  }

}
class AllOne {
  Map<String, Node> map;
  Node left, right;
  /** Initialize your data structure here. */
  public AllOne() {
    map = new HashMap<>();
    left = new Node(Integer.MIN_VALUE);
    right = new Node(Integer.MAX_VALUE);
    left.right = right; right.left = left;
  }
  public Node addToRight(Node node, String key, int val) {
    if (node.right.val == val) node.right.set.add(key);
    else {
      Node newNode = new Node(val);
      newNode.right = node.right;
      node.right.left = newNode;
      node.right = newNode;
      newNode.left = node;
      newNode.set.add(key);
    }
    return node.right;
  }
  public Node addToLeft(Node node, String key, int val) {
    if(node.left.val == val) node.left.set.add(key);
    else {
      Node newNode = new Node(val);
      newNode.left = node.left;
      node.left.right = newNode;
      node.left = newNode;
      newNode.right = node;
      newNode.set.add(key);
    }
    return node.left;
  }
  public void remove(Node node) {
    if (node == right || node == left) return;
    node.left.right = node.right;
    node.right.left = node.left;
  }
  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    if (!map.containsKey(key)) {
      Node node = addToRight(left, key, 1);
      map.put(key, node);
    } else {
      Node node = map.get(key);
      node.set.remove(key);
      node = addToRight(node, key, node.val + 1);
      map.put(key, node);
      if (node.left.set.isEmpty()) remove(node.left);
      // System.out.println(node.set + " node.val:" + node.val);
    }

  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    if (!map.containsKey(key) || map.get(key).set.isEmpty()) return;
    Node node = map.get(key);
    node.set.remove(key);
    if (node.val == 1 && node.set.isEmpty()) {
      remove(node);
      map.remove(key);
      return;
    }
    if (node.val > 1) {
      node = addToLeft(node, key, node.val - 1);
      map.put(key, node);
    }
    // System.out.println("node.val: " + node.val + " node.set" + node.set);
    // System.out.println("node.right.val: " + node.right.val + " node.right.set" + node.right.set);

    if (node.right.set.isEmpty()) {
      remove(node.right);
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    if (right.left.val != left.val && !right.left.set.isEmpty()) return right.left.set.iterator().next();
    return "";
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    // Node temp = left;
    // while (temp.right != null) {
    //     System.out.println("left.right=" + temp.set + " left.val = " + temp.val);
    //     temp = temp.right;
    // }
    if (left.right.val != right.val && !left.right.set.isEmpty()) return left.right.set.iterator().next();
    return "";
  }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */