class wallsAndGates {
    int[][] dir = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
    int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == 0) {
                    q.add(new int[] {row, col});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            for (int[] direction : dir) {
                int x = row + direction[0];
                int y = col + direction[1];
                if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || rooms[x][y] != INF) {
                    continue;
                }
                rooms[x][y] = rooms[row][col] + 1;
                q.add(new int[] {x, y});
            }
        }
    }
}