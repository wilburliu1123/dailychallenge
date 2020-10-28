int[][] dp;
public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return helper(1, n);
}
private int helper(int start, int end) {
        // if calculated, return the result
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        if (start >= end) {
            return 0;
        }
        if (start >= end - 2) {
            return dp[start][end] = end - 1;
        }
        int mid = (start + end) / 2 - 1, min = Integer.MAX_VALUE;
        while (mid < end) {
            int left = helper(start, mid - 1);
            int right = helper(mid + 1, end);
            min = Math.min(min, mid + Math.max(left, right));
            if (right <= left) break;
            mid++;
        }
        return dp[start][end] = min;
}