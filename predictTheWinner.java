public boolean PredictTheWinner(int[] nums) {
        return winner (nums, 0, nums.length - 1, 1) >= 0;
}
private int winner(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return turn * nums[start];
        }
        int a = turn * nums[start] + winner(nums, start + 1, end, -turn);
        int b = turn * nums[end] + winner(nums, start, end - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
}