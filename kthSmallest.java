class kthSmallest {
  public int kthSmallest(int[][] mat, int k) {
    int n = mat.length, m = mat[0].length;
    int l = n, r = n * 5000, res = -1;
    while (l < r) {
      int mid = l + (r - l + 1) / 2;
      int count = check(mat, mid, 0, 0, k);
      if (count >= k) {
        res = mid;
        r = mid - 1;
      } else {
        l = mid;
      }
    }
    return res;
  }
  int check(int[][] mat, int target, int r, int sum, int k) {
    int n = mat.length, m = mat[0].length;
    if (sum > target) return 0;
    if (r == n) return 1;
    int res = 0;
    for (int i = 0; i < m; i++) {
      int count = check(mat, target, r + 1, sum + mat[r][i], k - res);
      if (count == 0) break;
      res += count;
      if (res > k) break;
    }
    return res;
  }
}