class LongestValidParentheses {
  public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    int max = 0, cur = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
          if (!stack.isEmpty()) {
            max = Math.max(max, i - stack.peek());
          } else {
            max = Math.max(max, i - cur);
          }

        } else {
          cur = i;
        }
      }
    }
    return max;
  }
}