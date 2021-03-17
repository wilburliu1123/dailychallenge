class NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) return 0;
    Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
    int res = 1, end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= end) {
        res++;
        end = intervals[i][1];
      }
    }
    return intervals.length - res;
  }
}