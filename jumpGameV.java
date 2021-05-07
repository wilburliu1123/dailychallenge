class jumpGameV {
  public int maxJumps(int[] arr, int d) {
    int n = arr.length;
    int res = 0;
    int[] f = new int[n+1];
    Arrays.fill(f, 1);
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    for (int i = 0; i <= n; i++) {
      while (!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])) {
        int prev = arr[stack.peek()];
        while (!stack.isEmpty() && prev == arr[stack.peek()]) {
          int j = stack.pop();
          if (i - j <= d) {
            f[i] = Math.max(f[i], f[j] + 1);
          }
          stack2.push(j);
        }
        while (!stack2.isEmpty()) {
          int j = stack2.pop();
          if (!stack.isEmpty() && j - stack.peek() <= d) {
            f[stack.peek()] = Math.max(f[stack.peek()], f[j] + 1);
          }
        }
      }
      stack.push(i);
    }
    for (int i = 0; i < n; i++) {
      res = Math.max(res, f[i]);
    }
    return res;
  }
}