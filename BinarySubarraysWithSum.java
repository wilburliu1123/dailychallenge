class BinarySubarraysWithSum {
  public int numSubarraysWithSum(int[] nums, int goal) {
    int n = nums.length;
    int[] preSum = new int[n+1];
    for (int i = 1; i <= n; i++) {
      preSum[i] = preSum[i - 1] + nums[i-1];
    }
    int res = 0;
    // System.out.println(Arrays.toString(preSum));
    for (int i = 0; i < n; i++) {
      int j = i + 1;
      while (j <= n && preSum[j] - preSum[i] < goal) {
        j++;
      }
      while (j <= n && preSum[j] - preSum[i] == goal) {
        res++;
        j++;
      }
    }
    return res;
  }
}