class MeetingRooms2 {
  public int minMeetingRooms(int[][] intervals) {
    int[] start = new int[intervals.length];
    int[] end = new int[start.length];
    for (int i = 0; i < start.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int res = 0, endIdx = 0;
    for (int i = 0; i < start.length; i++) {
      if (start[i] < end[endIdx]) {
        res++;
      } else {
        endIdx++;
      }
    }
    return res;
  }
}