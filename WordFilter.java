class WordFilter {
  Trie trie = new Trie();
  public WordFilter(String[] words) {
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        String cur = words[i];
        trie.insert(cur.substring(j, cur.length()) + "{" + cur, i);
      }
    }
  }

  public int f(String prefix, String suffix) {
    return trie.search(suffix + "{" + prefix);
  }
}
class Trie {
  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }
  public void insert(String s, int num) {
    TrieNode node = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
      node = node.children[c - 'a'];
      node.id = num;
    }
  }

  public int search(String prefix) {
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (node.children[c - 'a'] == null) return -1;
      node = node.children[c - 'a'];
    }
    return node.id;
  }
}

class TrieNode {
  TrieNode[] children;
  int id;
  public TrieNode() {
    children = new TrieNode[27];
  }
}