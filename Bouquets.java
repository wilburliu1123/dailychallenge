class Bouquets {
  public int minDays(int[] b, int m, int k) {
    int l = 0, r = 1_000_000_001;
    if (b.length < m * k) return -1;
    while (l < r) {
      int M = 0;
      int mid = l + (r - l) / 2;
      int count = 0;
      for (int i = 0; i < b.length; i++) {
        if (b[i] <= mid) {
          count++;
        } else {
          if (count == k) {
            M++;
            count = 0;
          } else {
            count = 0;
          }
        }
        if (count == k) {
          M++;
          count = 0;
        }
        if (M >= m) break;
      }
      if (M >= m) r = mid;
      else l = mid + 1;
    }
    if (l == 1_000_000_001) return -1;
    return l;
  }
}