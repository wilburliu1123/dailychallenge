class MinSpeedOnTime {
  public int minSpeedOnTime(int[] dist, double hour) {
    double l = 1, r = 1e9;
    while (r - l > 1e-8) {
      double mid = l + (r - l) / 2;
      double total = 0d;
      for (int i = 0; i < dist.length; i++) {
        double cur = dist[i] / mid;
        if (i < dist.length - 1) {
          total += cur;
          total = Math.ceil(total);
        } else {
          total += cur;
        }
      }
      // total = Math.ceil(total);
      // System.out.println(total);
      if (total <= hour) {
        r = mid;
      } else {
        l = mid;
      }
      // System.out.println(l + " r " + r);
    }
    int res = (int) Math.ceil(l);
    return res == 1000000000 ? -1 : res;
  }
}