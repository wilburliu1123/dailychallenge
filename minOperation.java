class minOperatrion {
    public int minOperations(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum -= nums[right];
            while (sum < x && left <= right) {
                sum += nums[left];
                left++;
            }
            if (sum == x) {
                min = Math.min(min, nums.length - 1 - right + left);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // 6/5/2021 solution
    public int minOperations(int[] nums, int x) {
        int n = nums.length, res = Integer.MAX_VALUE;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int total = preSum[n];
        if (total == x) return n;
        if (total < x) return -1;
        for (int i = 0, j = 1; i <= n; i++) {
            while (j <= n && preSum[i] + total - preSum[j-1] > x) {
                j++;
            }
            if (total - (preSum[j-1] - preSum[i]) == x) {
                res = Math.min(res, n - (j - i) + 1);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}