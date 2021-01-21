class TrapRainWater {
    public int trapRainWater(int[][] heightMap) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.add(new int[] {i, 0, heightMap[i][0]});
            pq.add(new int[] {i, n-1, heightMap[i][n-1]});
        }
        for (int i = 1; i < n-1; i++) {
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.add(new int[] {0, i, heightMap[0][i]});
            pq.add(new int[] {m-1, i, heightMap[m-1][i]});
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    visited[i][j] = true;
                    res += Math.max(0, cur[2] - heightMap[i][j]);
                    pq.add(new int[] {i, j, Math.max(heightMap[i][j], cur[2])});
                }
            }
        }
        return res;
    }
}