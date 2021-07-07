class Solution {
  public int maxSubArray(int[] nums) {
    int n = nums.length;
    //f[i] = max(f[i-1], f[i-1] + nums[i]);
    int last = 0, res = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      last = nums[i] + Math.max(last, 0);
      res = Math.max(res, last);
    }
    return res;
  }
}