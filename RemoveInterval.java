class RemoveInterval {
  public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    int idx = 0, start = toBeRemoved[0], end = toBeRemoved[1];
    List<List<Integer>> res = new ArrayList<>();
    while (idx < intervals.length) {
      List<Integer> cur = new ArrayList<>();
      if (intervals[idx][1] < start || intervals[idx][0] > end) {
        res.add(Arrays.asList(intervals[idx][0], intervals[idx][1]));
        idx++;
      } else {
        // System.out.println(intervals[idx][1] + " " + end);
        if (intervals[idx][0] < start) {
          res.add(Arrays.asList(intervals[idx][0], start));
        }
        if (intervals[idx][1] > end) {
          res.add(Arrays.asList(end, intervals[idx][1]));
        }
        idx++;
      }
    }
    return res;
  }
}