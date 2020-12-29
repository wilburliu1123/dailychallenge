class jumpGameVI {
     public int maxResult(int[] nums, int k) {
         Deque<Integer> q = new ArrayDeque<>();
         int[] dp = new int[nums.length];
         dp[0] = nums[0];
         for (int i = 0; i < nums.length-1; i++) {
             while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();
             while (!q.isEmpty() && dp[q.peekLast()] <= dp[i]) {
                 q.pollLast();
             }
             q.offerLast(i);
             dp[i + 1] = nums[i + 1] + dp[q.peekFirst()];
         }
         return dp[nums.length-1];
     }
    // solution 2
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        pq.add(new int[] {nums[0], 0});
        for (int i = 1; i < nums.length; i++) {
            while (!pq.isEmpty() && i - pq.peek()[1] > k) pq.poll();
            dp[i] = nums[i] + dp[pq.peek()[1]];
            pq.add(new int[] {dp[i], i});
        }
        return dp[nums.length-1];
    }
}