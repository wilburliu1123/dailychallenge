class NumTriplets {
  public int numTriplets(int[] nums1, int[] nums2) {
    return calc(nums1, nums2) + calc(nums2, nums1);
  }
  private int calc(int[] n1, int[] n2) {
    Map<Long, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = 0; i < n1.length; i++) {
      long cur = (long)n1[i] * (long) n1[i];
      map.put(cur, map.getOrDefault(cur, 0) + 1);
    }
    // System.out.println(map);
    for (int j = 0; j < n2.length; j++) {
      for (int k = j + 1; k < n2.length; k++) {
        // System.out.println("n2[j] " + n2[j] + " n2[k]" + n2[k]);
        long current = (long) n2[j] * (long) n2[k];
        res += map.getOrDefault(current, 0);
      }
    }
    return res;
  }
}