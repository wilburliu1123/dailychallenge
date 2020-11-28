class maxWidthRamp {
    // solution 1: enumerate through the array and store the max
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = n-1;
            while (index >= i) {
                if (A[index] >= A[i]) {
                    break;
                }
                index--;
            }
            res = Math.max(res, index - i);
        }
        return res;
    }
    // solution 2: maintain a mono decreasing stack and update res from right hand side of the array
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        // store the max width of each element in an array
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // maintain a mono decreasing stack, store its index value
        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        // start from right side of array, update res when A[index] <= A[i] which means there exist a number in A[] that is >= to current index, store maximum
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}