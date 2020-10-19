public boolean makesquare(int[] nums) {
    if (nums == null || nums.length < 4) return false;
    int sum = 0;
    for (int i : nums) {
        sum += i;
    }
    if (sum % 4 != 0) return false;
    Arrays.sort(nums);
    reverse(nums);
    return dfs(nums, new int[4], 0, sum / 4);
}
private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            } else {
                return false;
            }
        }
        // iterate for 4 sides
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        return false;
}
private void reverse(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
}