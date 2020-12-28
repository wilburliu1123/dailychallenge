class shortestSumWithAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] preSum = new int[A.length + 1];
        int res = Integer.MAX_VALUE;
        // when add 0 in front of preSum, then right pointer will get range sum that represent the actual range
        // for example: preSum = [0, 2, 1, 3] then when preSum[3] - preSum[0] == target, we update result
        // note we are maintaining a monotonic increasing deque so preSum[0] will never get polled
        // unless we find a shorter range inside the array.
        // this way we could see if the whole array sum is equal to the target when no res is found inside the array
        for (int i = 0; i < A.length; i++) preSum[i+1] = preSum[i] + A[i];
        for (int i = 0; i <= A.length; i++) {
            // update res while range sum is great or equal to K
            while (!q.isEmpty() && preSum[i] - preSum[q.peekFirst()] >= K) {
                res = Math.min(res, i - q.pollFirst());
            }
            // if upcoming prefixSum is less than current last prefixSum, poll last element
            // because no res will be genereated
            while (!q.isEmpty() && preSum[q.peekLast()] >= preSum[i]) q.pollLast();
            q.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}