class NumArray {
  int[] nums;
  int[] tree;
  int n;
  public int lowbit(int x) {
    return x & -x;
  }

  public int query(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) res += tree[i];
    return res;
  }

  public void add(int x, int val) {
    for (int i = x; i <= n; i += lowbit(i)) {
      tree[i] += val;
    }
  }

  public NumArray(int[] nums) {
    this.n = nums.length;
    this.tree = new int[n+1];
    this.nums = nums;
    for (int i = 1; i <= n; i++) {
      tree[i] = nums[i-1];
      for(int j = i - 1; j > i - lowbit(i); j -= lowbit(j)) {
        tree[i] += tree[j];
      }
    }
  }

  public void update(int index, int val) {
    int diff = val - nums[index];
    this.nums[index] = val;
    add(index + 1, diff);
  }

  public int sumRange(int left, int right) {
    return query(right + 1) - query(left);
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */