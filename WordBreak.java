class WordBreak {
  Map<String, List<String>> memo = new HashMap<>();
  public List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    if (s.length() == 0) {
      return res;
    }
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    if (wordDict.contains(s)) {
      res.add(s);
    }
    for (int i = 1; i < s.length(); i++) {
      String str = s.substring(i);
      if (wordDict.contains(str)) {
        List<String> cur = wordBreak(s.substring(0, i), wordDict);
        for (String next : cur) {
          res.add(next + " "  + str);
        }
      }
    }
    memo.put(s, res);
    return res;
  }
}