class Permutation {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, new ArrayList<>(), nums);
    return res;
  }
  private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums) {
    if (cur.size() == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!cur.contains(nums[i])) {
        cur.add(nums[i]);
        helper(res, cur, nums);
        cur.remove(cur.size() - 1);
      }
    }
  }
}