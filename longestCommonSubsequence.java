public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] represents the longest common subsequence of text1[0...i] and text2[0...j];
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                //init
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[text1.length()][text2.length()];
}