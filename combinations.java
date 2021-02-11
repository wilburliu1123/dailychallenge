class Combinations {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    boolean[] visited = new boolean[n+1];
    helper(new ArrayList<>(), n, 1, k);
    return res;
  }
  private void helper(List<Integer> cur, int n, int start, int k) {
    if (k == 0) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = start; i <= n - k + 1; i++) {
      cur.add(i);
      helper(cur, n, i + 1, k-1);
      cur.remove(cur.size() - 1);
    }
  }
}