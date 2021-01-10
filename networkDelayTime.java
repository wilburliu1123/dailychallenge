class networkDelayTime {
    //bfs/dijkstra
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int[] ealiestTime = new int[N+1];
        Arrays.fill(ealiestTime, Integer.MAX_VALUE);
        ealiestTime[K] = 0;
        for (int[] row : times) {
            graph.computeIfAbsent(row[0], x -> new ArrayList<>()).add(new int[] {row[1], row[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {K, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // System.out.println(cur[1]);
            if (cur[1] > ealiestTime[cur[0]]) continue;
            List<int[]> next = graph.getOrDefault(cur[0], new ArrayList<>());
            for (int[] row : next) {
                if (cur[1] + row[1] < ealiestTime[row[0]]) {
                    ealiestTime[row[0]] = cur[1] + row[1];
                    q.offer(new int[] {row[0], cur[1] + row[1]});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, ealiestTime[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    // floyd
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dp = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        for (int[] row : times) {
            dp[row[0]][row[1]] = row[2];
        }
        // node has 0 delay to reach itself
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 0;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, dp[K][i]);
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}