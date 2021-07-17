class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();
    int n = nums.length;
    helper(nums, set, new ArrayList<>(), 0);
    List<List<Integer>> res = new ArrayList<>();
    // System.out.println(set);
    for (List<Integer> l : set) {
      res.add(l);
    }
    return res;
  }
  void helper(int[] nums, Set<List<Integer>> set, List<Integer> list, int i) {
    int n = nums.length;
    if (i > n) return;
    if (!set.contains(list))
      set.add(new ArrayList<>(list));
    for (int idx = i; idx < n; idx++) {
      list.add(nums[idx]);
      helper(nums, set, list, idx + 1);
      list.remove(list.size() - 1);
    }
  }
}