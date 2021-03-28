class MaxScore {
  public int maximumScore(int[] nums, int k) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(right, n);
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
        right[stack.peek()] = i;
        stack.pop();
      }
      left[i] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(i);
    }
    int res = nums[k];
    for (int i = 0; i < n; i++) {
      if (k - 1 >= left[i] && k + 1 <= right[i]) res = Math.max(res, (right[i] - left[i] - 1) * nums[i]);
    }
    return res;
  }
}