public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[s.length()][s.length()];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < dp.length; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[0][n-1] <= k;
}