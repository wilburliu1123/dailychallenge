class ShortestPathLength {
  public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    int[][] dp = new int[n][1<<n];  // 2^n possible state, 1<<n = 2^n
    Queue<State> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[i][1<<i] = 0;
      q.add(new State(1 << i, i));
    }
    while (!q.isEmpty()) {
      State cur = q.poll();
      for (int next : graph[cur.source]) { // graph[i] contains all possible states in mask i
        int nextMask = cur.mask | 1 << next;
        if (dp[next][nextMask] > dp[cur.source][cur.mask] + 1) {
          dp[next][nextMask] = dp[cur.source][cur.mask] + 1;
          q.add(new State(nextMask, next));
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, dp[i][(1<<n)-1]);
    }
    return res;
  }
  class State {
    int mask, source;
    public State(int m, int s) {
      this.mask = m;
      this.source = s;
    }
  }
}