class CountRangeSum {
  long[] tree;
  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, long val) {
    for (int i = x; i < tree.length; i += lowbit(i)) {
      tree[i] += val;
    }
  }

  long query(int x) {
    long res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += tree[i];
    }
    return res;
  }
  public int countRangeSum(int[] nums, int lower, int upper) {
    int n = nums.length;
    List<Long> numbers = new ArrayList<>();
    numbers.add(0L);
    long[] presum = new long[n+1];
    for (int i = 1; i <= n; i++) {
      presum[i] = presum[i-1] + nums[i-1];
      numbers.add(presum[i]);
      numbers.add(presum[i] - lower);
      numbers.add(presum[i] - upper - 1);
    }
    Collections.sort(numbers);
    Map<Long, Integer> map = new HashMap<>();
    int count = 0;
    for (long i : numbers) {
      if (!map.containsKey(i)) {
        map.put(i, ++count);
      }
    }
    this.tree = new long[count+1];
    int res = 0;
    add(map.get(0L), 1);
    for (int i = 1; i <= n; i++) {
      res += query(map.get(presum[i] - lower)) - query(map.get(presum[i] - upper - 1));
      add(map.get(presum[i]), 1);
    }
    return res;
  }
}