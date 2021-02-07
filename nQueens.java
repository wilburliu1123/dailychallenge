public class NQueens {
  List<List<String>> res = new ArrayList<>();
  boolean[] col, dg, udg;
  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
    col = new boolean[n];
    dg = new boolean[2*n];
    udg = new boolean[2*n];
    dfs(board, 0);
    return res;
  }
  void dfs(char[][] board, int row) {
    int n = board.length;
    if (row == n) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        StringBuilder cur = new StringBuilder();
        for (int j = 0; j < n; j++) {
          cur.append(board[i][j]);
        }
        list.add(cur.toString());
      }
      res.add(list);
      return;
    }
    for (int j = 0; j < n; j++) {
      if (!col[j] && !dg[row + j] && !udg[n + row - j]) {
        board[row][j] = 'Q';
        col[j] = dg[row + j] = udg[n + row - j] = true;
        dfs(board, row + 1);
        board[row][j] = '.';
        col[j] = dg[row + j] = udg[n + row - j] = false;
      }
    }
  }
}