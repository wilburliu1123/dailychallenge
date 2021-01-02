class constrainedSubsetSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        // Deque<Integer> res = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            while (!q.isEmpty() && j - q.peekFirst() > k) q.pollFirst();
            dp[j] = nums[j];
            if (!q.isEmpty()) dp[j] = Math.max(dp[j], nums[j] + dp[q.peekFirst()]);
            while (!q.isEmpty() && dp[q.peekLast()] <= dp[j]) q.pollLast();
            q.offerLast(j);

        }

        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}