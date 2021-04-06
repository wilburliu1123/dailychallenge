class DivideChocolate {
  public int maximizeSweetness(int[] sweetness, int K) {
    int l = 1, r = 0;
    int n = sweetness.length;

    for (int i = 0; i < n; i++) {
      r += sweetness[i];
    }
    while (l < r) {
      int mid = (l + r + 1)/ 2;
      int count = 0;
      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum += sweetness[i];
        if (sum >= mid) {
          count++;
          sum = 0;
        }
        if (count > K) break;
      }
      if (count > K) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }
}