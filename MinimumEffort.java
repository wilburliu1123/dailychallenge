class MinimumEffort {
  public int minimumEffort(int[][] tasks) {
    Arrays.sort(tasks, (a,b) -> {
      return (a[0] - a[1]) - (b[0] - b[1]);
    });
    int res = 0;
    int sum = 0;
    for (int[] task : tasks) {
      res = Math.max(sum + task[1], res);
      sum += task[0];

    }
    return res;
  }
}