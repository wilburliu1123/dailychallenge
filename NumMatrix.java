class NumMatrix {
  int[][] nums;
  int[][] tree;
  int n, m;
  int lowbit(int x) {
    return x & -x;
  }
  int query(int x, int y) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      for (int j = y; j > 0; j -= lowbit(j)) {
        res += tree[i][j];
      }
    }
    return res;
  }
  void add(int x, int y, int val) {
    for (int i = x; i <= n; i += lowbit(i)) {
      for (int j = y; j <= m; j += lowbit(j)) {
        tree[i][j] += val;
      }
    }
  }
  public NumMatrix(int[][] matrix) {
    this.n = matrix.length;
    this.m = matrix[0].length;
    this.nums = matrix;
    this.tree = new int[n+1][m+1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        add(i, j, nums[i-1][j-1]);
      }
    }
  }

  public void update(int row, int col, int val) {
    int diff = val - (sumRegion(row, col, row, col));
    this.nums[row][col] = val;
    add(row + 1, col + 1, diff);
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return query(row2 + 1, col2 + 1) - query(row1, col2 + 1) - query(row2 + 1, col1) + query(row1, col1);
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */