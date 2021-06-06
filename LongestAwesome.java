class LongestAwesome {
  public int longestAwesome(String s) {
    int res = 0, cur = 0, n = s.length(), map[] = new int[1024];
    Arrays.fill(map, n);
    map[0] = -1;
    for (int i = 0; i < n; i++) {
      cur ^= 1 << (s.charAt(i) - '0');
      for (int j = 0; j < 10; j++) {
        res = Math.max(res, i - map[cur ^ (1 << j)]);
      }
      res = Math.max(res, i - map[cur]);
      map[cur] = Math.min(map[cur], i);
    }

    return res;
  }
}