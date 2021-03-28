class MaxSum {
  public int maxSum(int[] nums1, int[] nums2) {
    int mod = 1_000_000_007;
    long res = 0;
    long a1 = 0, a2 = 0;
    int i = 0, j = 0;
    int n = nums1.length, m = nums2.length;
    while(i < n && j < m) {
      if (nums1[i] < nums2[j]) {
        a1 += nums1[i++];
      } else if (nums1[i] > nums2[j]) {
        a2 += nums2[j++];
      } else {
        //nums1[i] == nums2[j], assign both a1 and a2 to max value
        long max = Math.max(a1, a2) + nums1[i];
        a1 = a2 = max;
        i++;
        j++;
      }
    }
    while (i < n) {
      a1 += nums1[i++];
    }
    while (j < m) {
      a2 += nums2[j++];
    }
    res = Math.max(a1, a2);
    return (int) (res % mod);
  }
}