class Solution {
  int[] presum;
  int sum = 0;
  public Solution(int[] w) {
    int n = w.length;
    presum = new int[n+1];
    for (int i = 1; i <= n; i++) {
      presum[i] = presum[i-1] + w[i-1];
    }
    sum = presum[n];
  }

  public int pickIndex() {
    double prob = Math.random() * sum;
    int l = 0, r = presum.length-1;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (prob > presum[mid]) {
        l = mid + 1;
      } else {
        r = mid;
        // return mid;
      }

    }
    return l-1;
  }
}