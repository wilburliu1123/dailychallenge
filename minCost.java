class minCost {
    int[][] dirs = new int[][] {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        q.add(new int[] {0, 0, 0});
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[0][0] = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], cost = cur[2];
            if (distance[i][j] != cost) continue;
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0], y = j + dirs[k][1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int nCost = cost;
                    if (k != grid[i][j] - 1) nCost++;
                    if (nCost < distance[x][y]) {
                        distance[x][y] = nCost;
                        q.add(new int[] {x, y, nCost});
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}
