class MinArrowShots {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points, (a,b) -> a[1] - b[1]);
    int start = points[0][0], end = points[0][1];
    int res = 1;
    for (int i = 1; i < points.length; i++) {
      // System.out.println(end);
      if (end <= points[i][1] && end >= points[i][0]) {
        continue;
      } else {
        end = points[i][1];
        res++;
      }
    }
    return res;
  }
}