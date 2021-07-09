class MaxSubArrayLen {
  public int maxSubArrayLen(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0, sum = 0;
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      res = Math.max(res, i - map.getOrDefault(sum - k, i));
      map.putIfAbsent(sum, i);
    }
    return res;
  }
}
