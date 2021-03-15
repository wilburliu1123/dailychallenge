class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    int start = 0, end = 0;
    start = intervals[0][0];
    end = intervals[0][1];
    // for (int i = 0 ; i < intervals.length; i++) {
    //     System.out.print(Arrays.toString(intervals[i]));
    // }
    // System.out.println();
    List<int[]> list = new ArrayList<>();
    for (int i = 1; i < intervals.length; i++) {
      // System.out.println(start + " " + end);
      if (end > intervals[i][1]) {
        continue;
      } else if (end <= intervals[i][1] && end >= intervals[i][0]) {
        end = intervals[i][1];
        continue;
      } else {
        list.add(new int[] {start, end});
        if (i < intervals.length - 1) {
          start = intervals[i][0];
          end = intervals[i][1];
        }
      }
    }
    if (end > intervals[intervals.length-1][1]) {
    } else if (end <= intervals[intervals.length-1][1] && end >= intervals[intervals.length-1][0]) {
      end = intervals[intervals.length-1][1];
    } else {
      start = intervals[intervals.length-1][0];
      end = intervals[intervals.length-1][1];
    }
    list.add(new int[] {start, end});
    int[][] res = new int[list.size()][2];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}