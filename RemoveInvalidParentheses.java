class RemoveInvalidParenthese {
  List<String> res = new ArrayList<>();
  public List<String> removeInvalidParentheses(String s) {
    int l = 0, r = 0;
    char[] ch = s.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      char c = ch[i];
      if (c == '(') l++;
      else if (c == ')') {
        if (l > 0) l--;
        else r++;
      }
    }
    dfs(s, 0, "", 0, l, r);
    return res;
  }
  void dfs(String s, int idx, String path, int count, int l, int r) {
    if (idx == s.length()) {
      if (count == 0) res.add(path);
      return;
    }
    char c = s.charAt(idx);
    if (c != '(' && c != ')') dfs(s, idx + 1, path + c, count, l, r);
    else if (c == '(') {
      int k = idx;
      while (k < s.length() && s.charAt(k) == '(') k++;
      l -= k - idx;
      for (int i = k - idx; i >= 0; i--) {
        if (l >= 0) dfs(s, k, path, count, l, r);
        path += '(';
        count++;
        l++;
      }
    } else if (c == ')') {
      int k = idx;
      while (k < s.length() && s.charAt(k) == ')') k++;
      r -= k - idx;
      for (int i = k - idx; i >= 0; i--) {
        if (count >= 0 && r >= 0) dfs(s, k, path, count, l, r);
        path += ')';
        count--;
        r++;
      }
    }
  }
}