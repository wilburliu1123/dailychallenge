class IntervalIntersection {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> list = new ArrayList<>();
    int i = 0, j = 0;
    while (i < firstList.length && j < secondList.length) {
      int start = Math.max(firstList[i][0], secondList[j][0]);
      int end = Math.min(firstList[i][1], secondList[j][1]);
      if (start <= end) {
        list.add(new int[] {start, end});
      }
      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    int[][] res = new int[list.size()][2];
    for (int k = 0; k < list.size(); k++) {
      res[k] = list.get(k);
    }
    return res;
  }

  // 6/26
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> list = new ArrayList<>();
    int i = 0, j = 0;
    while (i < firstList.length && j < secondList.length) {
      int start = Math.max(firstList[i][0], secondList[j][0]);
      int end = Math.min(firstList[i][1], secondList[j][1]);
      if (start <= end) {
        list.add(new int[] {start, end});
      }
      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    int[][] res = new int[list.size()][2];
    for (int k = 0; k < res.length; k++) {
      res[k] = list.get(k);
    }
    return res;
  }
}