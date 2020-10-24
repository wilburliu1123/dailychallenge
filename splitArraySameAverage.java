public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int len = A.length;
        Arrays.sort(A);
        // search half of the length of A because if we divide the set into two, one of them will be less than half of A,
        // therefor we only need to search half of the set
        for (int i = 1; i <= len / 2; i++) {
            if (sum * i % len == 0) {
            // check if there exist a length i array that has sum = sum * i / length of B
                if (dfs(A, i, sum * i / len, 0)) {
                    return true;
                }
            }
        }
        return false;
}
private boolean dfs(int[] A, int len, int targetSum, int startIndex) {
        // base case
        if (targetSum == 0 && len == 0) {
            return true;
        }
        if (len != 0) {
            for (int i = startIndex; i < A.length; i++) {
                if (i > startIndex && A[i] == A[i - 1]) {
                    continue;
                }
                if (dfs(A, len - 1, targetSum - A[i], i + 1)) {
                    return true;
                }
            }
        }
        return false;
}