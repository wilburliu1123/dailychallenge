class CombinationSum2 {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    helper(new ArrayList<>(), candidates, target, 0);
    return res;
  }
  private void helper(List<Integer> cur, int[] arr, int target, int idx) {
    if (target == 0) {
      res.add(new ArrayList<>(cur));
      return;
    } else if (target < 0 || idx == arr.length) {
      return;
    }
    for (int i = idx; i < arr.length; i++) {
      if (i > idx && arr[i] == arr[i-1]) continue;
      cur.add(arr[i]);
      helper(cur, arr, target - arr[i], i + 1);
      cur.remove(cur.size() - 1);
    }
  }
}