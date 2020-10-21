int res = 0;
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        dp[i] = Integer.MAX_VALUE;
        for (int j : coins) {
        // if current amount i is greater than coin j, and left over value (i - j) is changable, and current change amount can be lesser, update the value;
            if (i - j >= 0 && dp[i - j] != Integer.MAX_VALUE && dp[i - j] + 1 < dp[i]) {
                dp[i] = dp[i - j] + 1;
            }
        }
    }
    if (dp[amount] == Integer.MAX_VALUE) {
        return -1;
    } else {
        return dp[amount];
    }
}