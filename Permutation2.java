class Permutation2 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    helper(res, new ArrayList<>(), nums, visited);
    return res;
  }
  private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
    if (cur.size() == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] || i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
      cur.add(nums[i]);
      visited[i] = true;
      helper(res, cur, nums, visited);
      visited[i] = false;
      cur.remove(cur.size() - 1);
    }
  }
}