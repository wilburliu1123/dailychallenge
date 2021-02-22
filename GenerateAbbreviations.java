class GenerateAbbreviations {
  List<String> res = new ArrayList<>();
  public List<String> generateAbbreviations(String word) {
    char[] c = word.toCharArray();
    helper(new StringBuilder(), c, 0, 0);
    return res;
  }
  void helper(StringBuilder sb, char[] c, int idx, int j) {
    int len = sb.length();
    if (idx == c.length) {
      if (j != 0) sb.append(j);
      res.add(sb.toString());
    } else {
      helper(sb, c, idx + 1, j + 1);
      if (j != 0) sb.append(j);
      sb.append(c[idx]);
      helper(sb, c, idx + 1, 0);
    }
    sb.setLength(len);
  }
}