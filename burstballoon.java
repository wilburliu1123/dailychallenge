public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null) {
            return 0;
        }

        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            A[i] = nums[i - 1];
        }
        int[][] f = new int[n + 2][n + 2];
        for (int i = 0; i < n + 1; i++) {
            f[i][i + 1] = 0;
        }

        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n - len + 2; i++) {
                int j = i + len - 1;
                f[i][j] = 0;
                // k is the index of last ballon burst
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }
        return  f[0][n + 1];
}