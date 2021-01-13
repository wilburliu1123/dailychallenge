class swimInWater {
    // union find
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        UF uf = new UF(n*m);
        int time = 0;
        while (!uf.connected(0, n * m - 1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > time) continue;
                    if (i < n - 1 && grid[i + 1][j] <= time) uf.union(i * n +j, (i + 1) * n + j);
                    if (j < m - 1 && grid[i][j + 1] <= time) uf.union(i * n +j, (i * n + j + 1));
                }
            }
            time++;
        }
        return time - 1;
    }
    // pq
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = new int[] {1, 0, -1, 0}, dy = new int[] {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        q.add(new int[] {grid[0][0], 0, 0});
        int waitTime = 0;
        while(true) {
            int[] cur = q.poll();
            // System.out.println(Arrays.toString(cur));
            waitTime = Math.max(waitTime, cur[0]);
            for (int j = 0; j < 4; j++) {
                int x = cur[1] + dx[j];
                int y = cur[2] + dy[j];
                if ((x >= 0 && x < n && y >= 0 && y < m) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[] {grid[x][y], x, y});
                }
            }
            if (cur[1] == n-1 && cur[2] == m-1) {
                return waitTime;
            }
        }
    }

}
class UF {
    int[] id;
    int[] sz;
    int count;
    public UF(int n) {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        if (connected(p, q)) return;
        int i = find(p);
        int j = find(q);
        if (sz[i] <= sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}