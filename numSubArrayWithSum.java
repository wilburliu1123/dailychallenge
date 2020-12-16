class numWithSubArrayWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int res = 0;
        for (int j = 0; j < A.length; j++) {
            prefixSum += A[j];
            if (map.containsKey(prefixSum - S)) {
                res += map.get(prefixSum - S);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}