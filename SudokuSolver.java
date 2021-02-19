class SodokuSolver {
  class Solution {
    public void solveSudoku(char[][] board) {
      helper(board);
    }

    public boolean helper(char[][] board) {
      int n = board.length;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (board[i][j] == '.') {
            for (char k = '1'; k <= '9'; k++) {
              if(isValid(board, i, j, k)) {
                board[i][j] = k;
                if(helper(board)) return true;
                board[i][j] = '.';
              }
            }
            return false;
          }
        }
      }
      return true;
    }
    private boolean isValid(char[][] board, int x, int y, char c) {
      for (int i = 0; i < 9; i++) {
        if (board[i][y] == c) {
          return false;
        }
      }
      for (int j = 0; j < 9; j++) {
        if (board[x][j] == c) {
          return false;
        }
      }
      for (int row = x / 3 * 3; row < x / 3 * 3 + 3; row++) {
        for (int col = y / 3 * 3; col < y / 3 * 3 + 3; col++) {
          if (board[row][col] == c) return false;
        }
      }
      return true;
    }
  }
}