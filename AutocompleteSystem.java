class AutocompleteSystem {
  Trie trie = new Trie();
  String curInput = "";
  public AutocompleteSystem(String[] sentences, int[] times) {
    for (int i = 0; i < sentences.length; i++) {
      trie.insert(sentences[i], times[i]);
    }
  }

  public List<String> input(char c) {
    List<String> res = new ArrayList<>();
    if (c == '#') {
      trie.insert(curInput);
      curInput = "";
    } else {
      curInput += c;
      List<Sentence> list = trie.search(curInput);
      // System.out.println(list);
      Collections.sort(list, (a, b) -> a.freq == b.freq ? a.sentence.compareTo(b.sentence) : b.freq - a.freq);
      for (int i = 0; i < Math.min(list.size(), 3); i++) {
        res.add(list.get(i).sentence);
      }
    }
    return res;
  }
}
class Sentence {
  String sentence;
  int freq;
  public Sentence(String str, int fq) {
    this.sentence = str;
    this.freq = fq;
  }
  @Override
  public String toString() {
    return sentence + " freq = " + this.freq;
  }
}
class Trie {
  TrieNode root;
  public Trie() {
    root = new TrieNode();
  }
  public void insert(String s) {
    TrieNode node = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int idx = c == ' ' ? 26 : c - 'a';
      if (node.children[idx] == null) node.children[idx] = new TrieNode();
      node = node.children[idx];
    }
    node.isSentence = true;
    node.freq++;
  }

  public void insert(String s, int times) {
    TrieNode node = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int idx = c == ' ' ? 26 : c - 'a';
      if (node.children[idx] == null) node.children[idx] = new TrieNode();
      node = node.children[idx];
    }
    node.isSentence = true;
    node.freq += times;
  }

  public List<Sentence> search(String s) {
    List<Sentence> res = new ArrayList<>();
    TrieNode node = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int idx = c == ' ' ? 26 : c - 'a';
      if (node.children[idx] == null) return new ArrayList<>();
      node = node.children[idx];
    }
    dfs(res, node, s);
    return res;
  }
  private void dfs(List<Sentence> res, TrieNode node, String s) {
    if (node.freq > 0) res.add(new Sentence(s, node.freq));
    for (char i = 'a'; i <= 'z'; i++) {
      if (node.children[i-'a'] != null) {
        dfs(res, node.children[i-'a'], s+i);
      }
    }
    if (node.children[26] != null) {
      dfs(res, node.children[26], s + ' ');
    }
  }
}
class TrieNode {
  TrieNode[] children;
  boolean isSentence;
  int freq;
  public TrieNode() {
    children = new TrieNode[27];
  }
}