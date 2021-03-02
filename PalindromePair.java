class PalindromePair {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<>();

    TrieNode root = new TrieNode();

    for (int i = 0; i < words.length; i++) {
      insert(root, words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      search(words[i], i, root, res);
    }

    return res;
  }

  private void insert(TrieNode root, String word, int index) {
    for (int i = word.length() - 1; i >= 0; i--) {
      int idx = word.charAt(i) - 'a';

      if (root.children[idx] == null) root.children[idx] = new TrieNode();
      if (isPalindrome(word, 0, i)) {
        root.list.add(index);
      }
      root = root.children[idx];
    }
    root.list.add(index);
    root.idx = index;
  }
  private void search(String word, int index, TrieNode node, List<List<Integer>> res) {
    for (int i = 0; i < word.length(); i++) {
      // if there is empty string "" in trie and current word is palindrome, add it to result
      if (node.idx != -1 && node.idx != index && isPalindrome(word, i, word.length() - 1)) {
        res.add(Arrays.asList(index, node.idx));
      }

      node = node.children[word.charAt(i) - 'a'];
      if (node == null) return;
    }

    for (int j : node.list) {
      if (index == j) continue;
      res.add(Arrays.asList(index, j));
    }
  }

  private boolean isPalindrome(String word, int i, int j) {
    while (i < j) {
      if (word.charAt(i++) != word.charAt(j--)) return false;
    }
    return true;
  }
}

class TrieNode {
  TrieNode[] children;
  int idx = -1;
  List<Integer> list = new ArrayList<>();
  TrieNode() {
    children = new TrieNode[26];
  }
}