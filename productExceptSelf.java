class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length, j = n-2;
    int[] l = new int[n], r = new int[n];
    Arrays.fill(l, 1);
    Arrays.fill(r, 1);
    for (int i = 1; i < n; i++) {
      r[j] = r[j+1] * nums[j+1];
      l[i] = l[i-1] * nums[i-1];
      j--;
    }
    // System.out.println(Arrays.toString(l));
    // System.out.println(Arrays.toString(r));
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = l[i] * r[i];
    }
    return ans;
  }
}