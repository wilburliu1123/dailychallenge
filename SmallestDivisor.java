class SmallestDivisor {
  public int smallestDivisor(int[] nums, int threshold) {
    int l = 0, r = 1_000_001;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int sum = 0;
      if (mid == 0) return 1;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i] % mid == 0 ? nums[i] / mid : nums[i] / mid + 1;
      }
      if (sum <= threshold) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return r == 1000001 ?  1 : l;
  }
}