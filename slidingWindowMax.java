class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        //monotonic queue
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && i - q.peekFirst() > k - 1) q.pollFirst(); //maintain window size
            // if upcoming number is greater than the last element in queue, pollLast element out
            // since we are maintaining a monotonic decreasing queue
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.pollLast();
            q.offerLast(i);
            if (i >= k-1) res[i-k+1] = nums[q.peekFirst()];
        }
        return res;
    }
}