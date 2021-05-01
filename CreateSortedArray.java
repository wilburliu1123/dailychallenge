class CreateSortedArray {
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

  public int createSortedArray(int[] instructions) {
    int mod = 1_000_000_007;
    this.n = 0;
    for (int i = 0; i < instructions.length; i++) {
      n = Math.max(n, instructions[i]);
    }
    tree = new int[n+1];
    long res = 0;
    for (int i = 0; i < instructions.length; i++) {
      int num = instructions[i];
      int small = query(num - 1);
      int large = i - query(num);
      res += Math.min(small, large);
      // add index to tree
      add(num, 1);
    }
    return (int) (res % mod);
  }
}