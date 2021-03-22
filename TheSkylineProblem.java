class TheSkylineProblem {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> res = new ArrayList<>();
    List<int[]> list = new ArrayList<>();
    for (int[] b : buildings) {
      list.add(new int[] {b[0], -b[2]}); //put start point for current building into list as height as negative
      list.add(new int[] {b[1], b[2]});
    }
    Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
    pq.add(0);
    for (int[] point : list) {
      int x = point[0], y = Math.abs(point[1]);
      if (point[1] < 0) {//start point for a building
        if (y > pq.peek()) {
          res.add(List.of(x, y));
        }
        pq.add(y);
      } else {
        pq.remove(point[1]);
        if (y > pq.peek()) {
          res.add(List.of(x, pq.peek()));
        }
      }
    }
    return res;
  }
}