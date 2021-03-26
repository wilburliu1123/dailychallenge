class NumSubSeq {
  public int numSubseq(int[] nums, int target) {
    int n = nums.length, mod = 1_000_000_007;
    int[] pow = new int[n];
    // calculate all 2^i for convinience
    pow[0] = 1;
    for (int i = 1; i < n; i++) pow[i] = pow[i-1] * 2 % mod;
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0, j = n - 1; i < n; i++) {
      while (j >= i && nums[i] + nums[j] > target) j--;
      if (j >= i && nums[i] + nums[j] <= target) {
        res += pow[j - i];
        res %= mod;
      }
    }
    return res;
  }
}