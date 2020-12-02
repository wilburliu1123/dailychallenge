class validateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == n;
    }
}