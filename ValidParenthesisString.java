class ValidParenthesisString {
  public boolean checkValidString(String s) {
    int low = 0, high = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        low++;
        high++;
      } else if (c == ')') {
        low--;
        high--;
      } else {
        low--;
        high++;
      }
      low = Math.max(0, low);
      if (low > high) return false;
    }
    return low == 0;
  }
}