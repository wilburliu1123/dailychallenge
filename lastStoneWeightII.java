public int lastStoneWeightII(int[] stones) {
        int sum = 0, diff = 0;
        for (int i : stones) {
            sum += i;
        }
        int n = stones.length;
        // 2d array to store
        // dp[i][j] is true if from 1st stone to jth stone, there has a sum equal to sum i, false otherwise
        // i is range of all sums (stones(i ... n)), j range from (1 ... n) n is the number of stones in stone array
        boolean[][] dp = new boolean[sum + 1][n + 1];
        // init
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        // calculate the ans
        for (int i = 1; i <= n; i++) {
        //record the max diff
            for (int j = 1; j <= sum / 2; j++) {
                if (dp[j][i-1] || (j >= stones[i - 1] && dp[j - stones[i - 1]][i - 1])) {
                    dp[j][i] = true;
                    diff = Math.max(diff, j);
                }
            }
        }
        return sum - 2 * diff;
}