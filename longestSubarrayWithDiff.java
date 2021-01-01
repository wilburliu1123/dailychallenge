class longestSubarrayWithDiff {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int res = 1;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[j]) maxQ.pollLast();
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[j]) minQ.pollLast();
            maxQ.offerLast(j);
            minQ.offerLast(j);
            while (Math.abs(nums[maxQ.peekFirst()] - nums[minQ.peekFirst()]) > limit) {
                if (maxQ.peekFirst() == i) maxQ.pollFirst();
                if (minQ.peekFirst() == i) minQ.pollFirst();
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}