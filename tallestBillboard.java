public int tallestBillboard(int[] rods) {
        // three choice, pick current rod, 1, don't pick 0, and welded with other rod -1
        // then it becomes knapsack, dp[i][j] represents whether the sum of first i numbers can be j - 5000 (5000 is the most we can get).
        // then dp[i + 1][j] = dp[i][j - rods[i]] | dp[i][j + rods[i]] | dp[i][j]

        int n = rods.length;
        boolean[][] dp = new boolean[n + 1][10001];
        int[][] max = new int[n + 1][10001];
        dp[0][5000] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j - rods[i] >= 0 && dp[i][j - rods[i]]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j - rods[i]] + rods[i]);
                }
                if (j + rods[i] <= 10000 && dp[i][j + rods[i]]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j + rods[i]]);
                }
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j]);
                }
            }
        }
        return max[n][5000];
}