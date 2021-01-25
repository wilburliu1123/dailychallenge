class CutOffTree {
    int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size(), m = forest.get(0).size(), count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = forest.get(i).get(j);
                if (cur > 1) {
                    count++;
                    pq.add(new int[] {i, j, cur});
                }
            }
        }

        // System.out.print(count);
        int[] start = new int[] {0,0};
        int sum = 0;
        while(!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = helper(forest, start, tree, n, m);
            if (step < 0) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;
    }
    private int helper(List<List<Integer>> forest, int[] start, int[] tree, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(start);
        visited[start[0]][start[1]] = true;
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                if (i == tree[0] && j == tree[1]) return step;
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && forest.get(x).get(y) != 0) {
                        visited[x][y] = true;
                        q.add(new int[] {x,y});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}