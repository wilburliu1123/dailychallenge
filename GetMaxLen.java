class GetMaxLen {
  public int getMaxLen(int[] nums) {
    int n = nums.length;
    int[] neg = new int[n], f = new int[n];
    if (nums[0] > 0) f[0] = 1;
    if (nums[0] < 0) neg[0] = 1;
    int res = f[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] < 0) {
        if (neg[i-1] > 0) f[i] = neg[i-1] + 1;
        neg[i] = f[i - 1] + 1;

      } else if (nums[i] > 0) {
        f[i] = f[i-1] + 1;
        if (neg[i-1] > 0) neg[i] = neg[i-1] + 1;
      }
      res = Math.max(res, f[i]);
    }
    return res;
  }
}