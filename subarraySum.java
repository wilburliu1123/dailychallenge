class SubArraySum {
  public int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0, n = nums.length, last = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    boolean[] visited = new boolean[n];
    map.put(0, 1);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      count += map.getOrDefault(sum - k, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}