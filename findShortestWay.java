class FindShortestWay {
    int[][] dirs = new int[][] {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    String[] strDirs = new String[] {"r", "l", "d", "u"};
    class Point implements Comparable<Point> {
        int x, y, dist;
        String str;
        public Point(int x, int y, int dist, String str) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.str = str;
        }
        public int compareTo(Point p) {
            return dist==p.dist ? str.compareTo(p.str) : dist - p.dist;
        }
    }
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = maze[0].length;
        Point[][] points = new Point[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
            }
        }
        dijkstra(maze, ball, hole, points);
        if(points[hole[0]][hole[1]].dist == Integer.MAX_VALUE) return "impossible";
        return points[hole[0]][hole[1]].str;
    }
    private void dijkstra(int[][] maze, int[] ball, int[] hole, Point[][] points) {
        int n = maze.length, m = maze[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.add(new Point(ball[0], ball[1], 0, ""));
        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            // System.out.println(cur.x + " " + cur.y);
            if (points[cur.x][cur.y].compareTo(cur)<=0) continue;
            points[cur.x][cur.y] = cur;
            for(int k = 0; k < 4; k++) {
                int[] dir = dirs[k];
                String curDir = cur.str + strDirs[k];
                int x = cur.x, y = cur.y, count = cur.dist;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (x != hole[0] || y != hole[1]) {
                    x -= dir[0];
                    y -= dir[1];
                    count--;
                }
                Point nP = new Point(x, y, count, curDir);
                pq.add(nP);
            }
        }
    }
}