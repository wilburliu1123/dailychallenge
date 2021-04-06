class ShipDdays {
  public int shipWithinDays(int[] weights, int D) {
    int l = 1, r = 1;
    int n = weights.length;
    for (int i = 0; i < n; i++) {
      l = Math.max(l, weights[i]);
      r += weights[i];
    }
    while (l < r) {
      int mid = l + (r - l) / 2;
      int sum = 0;
      int count = 1;
      for (int i = 0; i < n; i++) {
        if (sum + weights[i] <= mid) {
          sum += weights[i];
        } else {
          count++;
          sum = weights[i];
        }
      }
      if (count <= D) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}