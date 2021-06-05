class MaxSumDivisibleByP {
//  O(n^2) solution, this will TLE
     public int minSubarray(int[] nums, int p) {
       int n = nums.length;
       long[] preSum = new long[n + 1];
       for (int i = 1; i <= n; i++) {
           preSum[i] = preSum[i-1] + nums[i-1];
       }
       int res = Integer.MAX_VALUE;
       long total = preSum[n];
       // System.out.println(total);
       if (total % p == 0) return 0;
       for (int i = 1; i <= n; i++) {
           for (int j = 0; j < i; j++) {
               long sum = preSum[i] - preSum[j];
               if (sum == total) continue;
               if ((total - sum) % p == 0) {
                   res = Math.min(res, i - j);
               }
           }
       }
       return res == Integer.MAX_VALUE ? -1 : res;
   }
   // optimized to O(n) using map to store the remainder of current prefix sum and its corresponding index
  public int minSubarray(int[] nums, int p) {
    // all we need is the remainder of sum % p
    int n = nums.length;
    int remain = 0, cur = 0;
    for (int i = 0; i < n; i++) {
      remain = (remain + nums[i]) % p;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int res = Integer.MAX_VALUE;
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      cur = (cur + nums[i]) % p;
      map.put(cur, i);
      int complement = (cur - remain + p) % p;
      if (map.containsKey(complement)) {
        res = Math.min(res, i - map.get(complement));
      }

    }
    return res < n ? res : -1;
  }
}