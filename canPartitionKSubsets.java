class Solution {
  public boolean canPartitionKSubsets(int[] nums, int k) {
    // Set<List<Integer>> set = new HashSet<>();
    int sum = 0, max = 0;
    for (int i : nums) {
      sum += i;
      max = Math.max(max, i);
    }
    if (sum % k != 0 || max > sum / k) return false;
    return ablePartition(nums, new boolean[nums.length], 0, sum / k, 0, k);
  }
  boolean ablePartition(int[] nums, boolean[] visited, int sum, int targetSum, int idx, int k) {
    int n = nums.length;
    if (idx > n && k != 0) return false;
    if (k == 0) return true;
    if (sum == targetSum) {
      return ablePartition(nums, visited, 0, targetSum, 0, k - 1);

    }
    for (int i = idx; i < n; i++) {
      if (!visited[i] && sum + nums[i] <= targetSum) {
        visited[i] = true;
        if (ablePartition(nums, visited, sum + nums[i], targetSum, i + 1, k)) {
          return true;
        }
        visited[i] = false;
      }
    }
    return false;
  }
}