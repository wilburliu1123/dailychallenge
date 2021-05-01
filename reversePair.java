class ReversePair {
  int[] tree;
  int n;
  int lowbit(int x) {
    return x & -x;
  }
  void add(int x, int val) {
    for (int i = x; i <= n; i += lowbit(i)) {
      tree[i] += val;
    }
  }

  int query(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += tree[i];
    }
    return res;
  }
  public int reversePairs(int[] nums) {

    TreeSet<Long> set = new TreeSet<>();
    for (int i : nums) {
      set.add((long) i);
      set.add((long) 2*i);
    }
    this.n = set.size();
    tree = new int[n+1];
    Map<Long, Integer> map = new HashMap<>();
    int idx = 1;
    for (long i : set) map.put(i, idx++);
    int res = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      res += query(map.get((long) nums[i]) - 1);
      add(map.get((long) nums[i] * 2), 1);
    }
    return res;
  }
}