class CombinationSum3 {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum3(int k, int n) {
    helper(new ArrayList<>(), k, n, 0, 1);
    return res;
  }
  void helper(List<Integer> cur, int k, int n, int count, int idx) {
    if (count >= k) {
      if (n == 0) {
        res.add(new ArrayList<>(cur));
      }
      return;
    }
    for (int i = idx; i < 10; i++) {
      cur.add(i);
      helper(cur, k, n - i, count + 1, i + 1);
      cur.remove(cur.size() - 1);
    }
  }
}