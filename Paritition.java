class Paritition {
  List<List<String>> res = new ArrayList<>();
  public List<List<String>> partition(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = (j - i + 1 < 3 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
      }
    }
    helper(new ArrayList<String>(), s, 0, dp);
    return res;
  }
  void helper(List<String> cur, String s, int idx, boolean[][] dp) {
    int n = s.length();
    if (idx == n) {
      res.add(new ArrayList<>(cur));
    }
    for (int i = idx; i < n; i++) {
      if (dp[idx][i]) {
        cur.add(s.substring(idx, i + 1));
        helper(cur, s, i + 1, dp);
        cur.remove(cur.size() - 1);
      }
    }
  }
}