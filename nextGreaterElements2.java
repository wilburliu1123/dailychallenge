class nextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            // monotonous increasing stack to store the index of nums
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                res[stack.pop()] = nums[i % n];
            stack.push(i % n);
        }
        return res;
    }
}