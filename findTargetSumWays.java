public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // check if it is out of range
        if (S > sum || S < -sum) {
            return 0;
        }
        int[] dp = new int[sum * 2 + 1];
        // base case: dp[sum] = 1  if we add all numbers
        // recurrence relation: when doing inner loop iterations, we should create another temp dp array to store temp
        dp[sum] = 1;
        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[sum * 2 + 1];
                for (int j = 0; j < sum * 2 + 1; j++) {
                    if (dp[j] != 0) {
                        temp[j + nums[i]] += dp[j];
                        temp[j - nums[i]] += dp[j];
                    }
                }
            dp = temp;
        }
        return dp[sum + S];
}