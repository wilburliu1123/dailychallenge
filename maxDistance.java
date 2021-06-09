class MaxDistance {
  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int n = position.length, l = 0, r = position[n-1];
    while (l < r) {
      int mid = l + (r - l + 1) / 2;
      if (check(position, m, mid)) l = mid;
      else r = mid - 1;
    }
    return l;
  }
  boolean check(int[] position, int m, int max) {
    int left = position[0];
    int count = 1;
    for (int i = 0; i < position.length; i++) {
      if (position[i] - left >= max) {
        left = position[i];
        count++;
      }
    }
    return count >= m;
  }
}