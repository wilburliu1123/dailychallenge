class ScoreOfParentheses {
  public int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') stack.push(0);
      else {
        int cur = stack.pop();
        if (cur == 0) {
          cur = 1;
        } else {
          cur *= 2;
        }
        int sum = stack.pop();
        sum += cur;
        stack.push(sum);
      }
    }
    return stack.peek();
  }
}