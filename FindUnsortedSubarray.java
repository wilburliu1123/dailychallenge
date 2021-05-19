class FindUnsortedSubarray {
  public int findUnsortedSubarray(int[] nums) {
    int l = 0, r = nums.length -1;
    while (l < nums.length - 1 && nums[l + 1] >= nums[l]) l++;
    if (l == r) {
      return 0;
    }
    while (r - 1 >= 0 && nums[r - 1] <= nums[r]) r--;
    for (int i = l + 1; i < nums.length; i++) {
      while (l >= 0 && nums[l] > nums[i]) {
        l--;
      }
    }
    for (int i = r - 1; i >= 0; i--) {
      while (r < nums.length && nums[r] < nums[i]) r++;
    }
    return r - l - 1;
  }
}