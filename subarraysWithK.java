class subarraysWithK {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K-1);
    }
    private int atMostK(int[] A, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            while (map.keySet().size() > k) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
}