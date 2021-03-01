class MaxXOR {
  public int[] maximizeXor(int[] nums, int[][] queries) {
    int max = 0;
    int n = queries.length;
    Trie trie = new Trie();
    Arrays.sort(nums);
    List<Node> nodes = new ArrayList<>();
    // PQ will TLE...
    // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    for (int i = 0; i < n; i++) {
      int[] query = queries[i];
      int xi = query[0], mi = query[1];
      nodes.add(new Node(xi, mi, i));
    }
    Collections.sort(nodes, (a, b) -> a.m - b.m);
    int[] res = new int[n];
    for (int i = 0, j = 0; j < n; j++) {
      while (i < nums.length && nums[i] <= nodes.get(j).m) trie.insert(nums[i++]);
      res[nodes.get(j).k] = trie.search(nodes.get(j).x);
    }

    return res;
  }
}

class Node {
  int x, m, k;
  public Node(int x, int m, int k) {
    this.x = x;
    this.m = m;
    this.k = k;
  }

}

class Trie {
  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }
  public int search(int n) {
    TrieNode node = root;
    if (node.children[0] == null && node.children[1] == null) return -1;
    int res = 0;
    for (int i = 30; i >= 0; i--) {
      int cur = n >> i & 1;
      if (node.children[cur ^ 1] == null) {
        node = node.children[cur];
        res = res * 2 + cur;
      } else {
        node = node.children[cur ^ 1];
        res = res * 2 + cur ^ 1;
      }
    }
    return res ^ n;
  }
  public void insert(int n) {
    TrieNode node = root;
    for (int i = 30; i >= 0; i--) {
      int cur = n >> i & 1;
      if (node.children[cur] == null) node.children[cur] = new TrieNode();
      node = node.children[cur];
    }
  }
}
class TrieNode {
  TrieNode[] children;
  public TrieNode() {
    children = new TrieNode[2];
  }
}