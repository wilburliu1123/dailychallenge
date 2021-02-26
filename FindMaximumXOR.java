class FindMaximumXOR {
  public int findMaximumXOR(int[] nums) {
    Trie trie = new Trie();
    int res = 0;
    for (int num : nums) {
      trie.insert(num);
      res = Math.max(res, trie.search(num));
    }
    return res;
  }
}
class Trie {
  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }

  public void insert(int x) {
    TrieNode node = root;
    for (int i = 30; i >= 0; i--) {
      int cur = x >> i & 1;
      if (node.children[cur] == null) node.children[cur] = new TrieNode();
      node = node.children[cur];
    }
    node.num = x;
  }

  public int search(int x) {
    TrieNode node = root;
    int res = 0;
    for (int i = 30; i >= 0; i--) {
      int cur = x >> i & 1;
      int negate = ~cur;
      negate += 2;
      if (node.children[negate] != null) {
        node = node.children[negate];
        res = res * 2 + negate;
      } else {
        node = node.children[cur];
        res = res * 2 + cur;
      }
    }
    return res ^ x;
  }
}
class TrieNode {
  TrieNode[] children;
  int num;
  public TrieNode() {
    children = new TrieNode[2];
  }
}