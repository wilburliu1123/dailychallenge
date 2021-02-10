class Subsets {
  List<List<Integer>> res = new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
    helper(nums, 0, new ArrayList<>());
    return res;
  }
  private void helper(int[] nums, int idx, List<Integer> cur) {
    if (idx > nums.length) {
      return;
    }
    res.add(new ArrayList<>(cur));
    for (int i = idx; i < nums.length; i++) {
      cur.add(nums[i]);
      helper(nums, i + 1, cur);
      cur.remove(cur.size() - 1);
    }
  }
}