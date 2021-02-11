class CombinationSum {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    helper(new ArrayList<>(), candidates, target, 0);
    return res;
  }
  private void helper(List<Integer> cur, int[] arr, int target, int idx) {
    if (target == 0) {
      res.add(new ArrayList<>(cur));
      return;
    } else if (target < 0) {
      return;
    }
    for (int i = idx; i < arr.length; i++) {
      cur.add(arr[i]);
      helper(cur, arr, target - arr[i], i);
      cur.remove(cur.size() - 1);
    }
  }
}