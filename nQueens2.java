class nQueens2 {
  int res = 0;
  public int totalNQueens(int n) {
    //char[][] board is not required since we don't need to show how queens it is placed
    boolean[] row = new boolean[n], col = new boolean[n], dg = new boolean[2*n], udg = new boolean[2*n];
    dfs(0, 0, row, col, dg, udg);
    return res;
  }
  private void dfs(int y, int count, boolean[] row, boolean[] col, boolean[] dg, boolean[] udg) {
    int n = row.length;
    if (y == n && count == n) {
      res++;
      return;
    } else if (y == n) {
      return;
    }
    for (int x = 0; x < n; x++) {
      if (!row[x] && !col[y] && !dg[x+y] && !udg[n - x + y]) {
        row[x] = col[y] = dg[x+y] = udg[n - x + y] = true;
        dfs(y + 1, count + 1, row, col, dg, udg);
        row[x] = col[y] = dg[x+y] = udg[n - x + y] = false;
      }
    }
  }
}