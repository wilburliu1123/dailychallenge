class DifferentWaysToAddParentheses {
  public List<Integer> diffWaysToCompute(String expression) {
    List<Integer> ans = new ArrayList<>();
    int n = expression.length();
    for (int i = 0; i < n; i++) {
      char c = expression.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> left = diffWaysToCompute(expression.substring(0, i));
        List<Integer> right = diffWaysToCompute(expression.substring(i+1));
        for (int x : left) {
          for (int y : right) {
            int res = 0;
            if (c == '+') res = x + y;
            else if (c == '-') res = x - y;
            else res = x * y;
            ans.add(res);
          }
        }
      }
    }
    if (ans.size() == 0) ans.add(Integer.parseInt(expression));
    return ans;
  }
}