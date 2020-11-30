class mostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && nums.length - i > k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }
        for (int j = k - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }
}