class MinMaxGasStationD {
  public double minmaxGasDist(int[] stations, int k) {
    int n = stations.length;
    double l = 0d, r = stations[n - 1] - stations[0];
    while (r - l > 1e-6) {
      double mid = (l + r) / 2;
      int count = 0;
      for (int i = 0; i < n - 1; i++) {
        count += (int) ((stations[i+1] - stations[i]) / mid);
        if (count > k) break;
      }
      if (count <= k) {
        r = mid;
      } else {
        l = mid;
      }
    }
    return l;
  }
}