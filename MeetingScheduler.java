class MeetingScheduler {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, (a,b) -> a[0] - b[0]);
    Arrays.sort(slots2, (a,b) -> a[0] - b[0]);
    int j = 0;
    List<Integer> res = new ArrayList<>();
    int i = 0;
    while (i < slots1.length) {
      if (j < slots2.length) {
        if (slots1[i][1] <= slots2[j][1] && slots1[i][1] >= slots2[j][0]) {
          int start = Math.max(slots2[j][0], slots1[i][0]);
          int end = Math.min(slots2[j][1], slots1[i][1]);
          if (end - start >= duration) {
            res.add(start);
            res.add(start + duration);
            return res;
          }
          i++;
        } else if (slots2[j][1] <= slots1[i][1] && slots2[j][1] >= slots1[i][0]) {
          int start = Math.max(slots2[j][0], slots1[i][0]);
          int end = Math.min(slots2[j][1], slots1[i][1]);
          if (end - start >= duration) {
            res.add(start);
            res.add(start + duration);
            return res;
          }
          j++;
        } else {
          if (slots1[i][1] >= slots2[j][1]) {
            j++;
          } else {
            i++;
          }
        }
      } else {
        break;
      }
    }
    return res;
  }

  // 6/26
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, (a,b) -> a[0] - b[0]);
    Arrays.sort(slots2, (a,b) -> a[0] - b[0]);
    int i = 0, j = 0;
    List<Integer> res = new ArrayList<>();
    while (i < slots1.length) {
      if (j < slots2.length) {
        if (slots1[i][1] <= slots2[j][1] && slots1[i][1] >= slots2[j][0]) {
          int start = Math.max(slots2[j][0], slots1[i][0]);
          int end = Math.min(slots2[j][1], slots1[i][1]);
          if (end - start >= duration) {
            res.add(start);
            res.add(start + duration);
            return res;
          }
          i++;
        } else if (slots2[j][1] <= slots1[i][1] && slots2[j][1] >= slots1[i][0]) {
          int start = Math.max(slots2[j][0], slots1[i][0]);
          int end = Math.min(slots2[j][1], slots1[i][1]);
          if (end - start >= duration) {
            res.add(start);
            res.add(start + duration);
            return res;
          }
          j++;
        } else {
          if (slots1[i][1] >= slots2[j][1]) {
            j++;
          } else {
            i++;
          }
        }
      } else {
        break;
      }
    }
    return res;
  }
}