class RemoveCoveredIntervals {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int end = 0, res = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (intervals[i][1] > end) {
        end = intervals[i][1];
        res++;
      }
    }
    return res;
  }
}