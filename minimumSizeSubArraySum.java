class minimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = -1; // left pointer
        int sum = 0;
        for (int j = 0; j < nums.length; j++) { //right pointer
            sum += nums[j];
            while (sum >= s) {
                min = Math.min(min, j - left);
                left++;
                sum -= nums[left];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}