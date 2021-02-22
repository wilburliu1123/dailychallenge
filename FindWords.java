class FindWords {
  class Solution {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Set<Integer> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
      Trie trie = new Trie();
      for (int i = 0; i < words.length; i++) trie.insert(words[i], i);
      int n = board.length, m = board[0].length;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          char c = board[i][j];
          if (trie.root.children[c-'a'] != null) {
            dfs(board, trie.root.children[c-'a'], i, j);
          }
        }
      }
      List<String> res = new ArrayList<>();
      for (int idx : set) res.add(words[idx]);
      return res;
    }
    private void dfs(char[][] board, TrieNode node, int x, int y) {
      if (node.isWord) {
        set.add(node.id);
      }
      char temp = board[x][y];
      // mark as visited
      board[x][y] = '.';
      for (int[] dir : dirs) {
        int i = x + dir[0], j = y + dir[1];
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != '.') {
          char c = board[i][j];
          if (node.children[c-'a'] != null) dfs(board, node.children[c-'a'], i, j);
        }
      }
      board[x][y] = temp;
    }
  }
  class Trie {
    TrieNode root;
    public Trie() {
      root = new TrieNode();
    }
    public void insert(String s, int id) {
      TrieNode node = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (node.children[c - 'a'] == null) node.children[c-'a'] = new TrieNode();
        node = node.children[c-'a'];
      }
      node.id = id;
      node.isWord = true;
      node.freq++;
    }
    public boolean search(String s) {
      TrieNode node = root;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (node.children[c - 'a'] == null) return false;
        node = node.children[c - 'a'];
      }
      return node.isWord;
    }
  }
  class TrieNode {
    TrieNode[] children;
    int id;
    boolean isWord;
    int freq = 0;
    public TrieNode() {
      children = new TrieNode[26];
      id = -1;
    }
  }

}