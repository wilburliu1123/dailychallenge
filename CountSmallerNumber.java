class CountSmallerNumber {
  int[] tree;
  int n = 20001;
  int constant = 10001;
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
  public List<Integer> countSmaller(int[] nums) {
    tree = new int[n+1];
    List<Integer> list = new ArrayList<>();
    int[] res = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int x = nums[i] + constant;
      res[i] = query(x-1);
      add(x, 1);
    }
    return Arrays.stream(res).boxed().collect(Collectors.toList());
  }
}