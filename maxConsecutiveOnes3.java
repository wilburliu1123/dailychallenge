class maxConsecutiveOnes3 {
    public int longestOnes(int[] A, int k) {
        int count = k;
        int left = 0;
        int res = 0;
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 1) {
                res = Math.max(res, right - left + 1);
            } else {
                count--;
                while (count < 0) {
                    if (A[left] == 0) {
                        count++;
                    }
                    left++;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res == 0 ? k : res;
    }
}