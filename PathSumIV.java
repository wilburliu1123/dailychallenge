class PathSumIV {
  public int pathSum(int[] nums) {
    int[][] mat = new int[5][9];
    for (int n: nums) {
      int i = n / 100;
      int j = (n % 100) / 10 - 1;
      int val = n % 10;
      mat[i][j] = mat[i-1][j/2] + val;
    }
    int sum = 0;
    for (int i = 1; i <= 4; i++) {
      for (int j = 0; j <= 8; j++) {
        if (i == 4 || mat[i][j] != 0 && mat[i+1][j*2] == 0 && mat[i+1][j*2+1] == 0) {
          // leaf node
          sum += mat[i][j];
        }
      }
    }
    return sum;
  }
}