class find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < stack.peek()[0]) {
                stack.push(new int[] {nums[i], nums[i]});
            } else if (nums[i] > stack.peek()[0]) {
                int[] last = stack.pop();
                if (nums[i] < last[1]) {
                    return true;
                } else {
                    last[1] = nums[i];
                    while (!stack.isEmpty() && nums[i] >= stack.peek()[1]) {
                        stack.pop();
                    }
                    // if stack is not empty, this means nums[i] < stack.peek()[1], then check if stack.peek()[0] is less than nums[i]
                    if (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                        return true;
                    }
                    stack.push(last);
                }
            }
        }
        return false;
    }
}