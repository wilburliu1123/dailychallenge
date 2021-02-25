class WordDictionary {
  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }

  public void addWord(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (node.children[c-'a'] == null) node.children[c-'a'] = new TrieNode();
      node = node.children[c - 'a'];
    }
    node.isWord = true;
  }

  public boolean search(String word) {
    return searchWithDot(word, root, 0);
  }
  public boolean searchWithDot(String word, TrieNode node, int idx) {
    if (idx == word.length()) return node.isWord;
    char c = word.charAt(idx);
    if (c != '.') {
      if (node.children[c - 'a'] == null) return false;
      return searchWithDot(word, node.children[c - 'a'], idx + 1);
    } else {
      for (int i = 0; i < 26; i++) {
        if (node.children[i] != null && searchWithDot(word, node.children[i], idx + 1)) {
          return true;
        }
      }
      return false;
    }
  }
}
class TrieNode {
  TrieNode[] children;
  boolean isWord;
  public TrieNode() {
    children = new TrieNode[26];
  }
}