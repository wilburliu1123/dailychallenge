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
}