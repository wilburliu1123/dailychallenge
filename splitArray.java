class splitArray {
    public int splitArray(int[] nums, int m) {
      int n = nums.length;
      long l = 0, r = 0;
      for (int i = 0; i < n; i++) {
        if (l < nums[i])
          l = nums[i];
        r += nums[i];
      }
      long res = r;
      while (l < r) {
        long mid = l + (r - l) / 2;
        long sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
          if (sum + nums[i] > mid) {
            count++;
            sum = nums[i];
          } else {
            sum += nums[i];
          }
        }
        if (count > m) {
          l = mid + 1;
        } else {
          res = Math.min(res, mid);
          r = mid;
        }
      }
      return (int) res;
    }
}