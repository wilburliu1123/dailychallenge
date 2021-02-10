class Subsetes2 {
  Set<List<Integer>> set = new HashSet<List<Integer>>();
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    helper(set, new ArrayList<>(), nums, 0);
    List<List<Integer>> res = new ArrayList<>();
    for (List<Integer> list : set) {
      res.add(list);
    }
    return res;
  }
  private void helper(Set<List<Integer>> set, List<Integer> cur, int[] nums, int idx) {
    if (idx > nums.length) {
      return;
    }
    set.add(new ArrayList<>(cur));
    for (int i = idx; i < nums.length; i++) {
      cur.add(nums[i]);
      helper(set,cur, nums, i+1);
      cur.remove(cur.size() - 1);
    }
  }
}