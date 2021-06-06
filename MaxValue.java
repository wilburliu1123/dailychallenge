class MaxValue {
  public int maxValue(int n, int index, int maxSum) {
    maxSum -= n;
    int l = 0, r = maxSum;
    while (l < r) {
      int mid = l + (r - l + 1) / 2;
      if (test(n, index, mid) <= maxSum) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l + 1;
  }
  long test(int n, int index, int target) {
    int b = Math.max(target - index, 0);
    long res = (long) (target+b) * (target - b + 1) / 2;
    b = Math.max(target - ((n - 1) - index), 0);
    res += (long) (target + b) * (target - b + 1) / 2;
    return res - target;
  }
}