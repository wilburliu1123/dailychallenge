class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) return new int[][] {newInterval};
    List<int[]> list = new ArrayList<>();
    int idx = 0;
    int start = newInterval[0], end = newInterval[1];
    while (idx < intervals.length && start > intervals[idx][1]) {
      list.add(intervals[idx++]);
    }
    while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
      start = Math.min(start, intervals[idx][0]);
      end = Math.max(end, intervals[idx][1]);
      idx++;
    }
    list.add(new int[] {start, end});
    while (idx < intervals.length) {
      list.add(intervals[idx++]);
    }
    int[][] res = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}