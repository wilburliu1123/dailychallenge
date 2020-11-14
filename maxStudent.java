public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] validRows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                validRows[i] = (validRows[i] << 1) + (seats[i][j] == '.' ? 1 :0);
            }
        }
        int stateSize = 1 << n; //2 ^ n states for n columns in binary format
        int[][] dp = new int[m][stateSize];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < stateSize; j++) {
            // check if j is a subset of validRows
            // (j & (j >> 1)) is checking if there is no adjacent student in the row
                if (((j & validRows[i]) == j) && ((j & (j >> 1)) == 0)) {
                    if (i == 0) {
                    dp[i][j] = Integer.bitCount(j);
                    } else {
                        // (j & (k >> 1)) == 0 means no students in the upper left positions
                        // ((j >> 1) & k) == 0: no students in the upper right positions
                        // dp[i-1][k] != -1: there is previous state
                        for (int k = 0; k < stateSize; k++) {
                            if ((j & (k >> 1)) == 0 && ((j >> 1) & k) == 0 && dp[i-1][k] != -1) {
                                dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
                            }
                        }
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
}