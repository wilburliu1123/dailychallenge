class Maze {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length, m = maze[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijsktra(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    private void dijsktra(int[][] maze, int[] start, int[][] distance) {
        int n = maze.length, m = maze[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        q.add(new int[] {start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1], count = 0;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    q.add(new int[] {x, y, distance[x][y]});
                }
            }
        }
    }
}
