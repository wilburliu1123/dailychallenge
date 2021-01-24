class FlipMatrix {
    // add [0,0] to dirs because we need to flip the cell and its neighbor.
    int[][] dirs = new int[][] {{0,0}, {0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minFlips(int[][] mat) {
        int start = 0, end = 0, n = mat.length, m = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                start |= mat[i][j] << (i * m + j);
            }
        }
        // bfs
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                // System.out.println(cur);
                if (cur == end) return step;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        int next = cur;
                        for (int[] dir : dirs) {
                            int row = x + dir[0], col = y + dir[1];
                            // if it is within boundary, flip all neighbors and store it to 'next' variable
                            if (row >= 0 && row < n && col >= 0 && col < m) {
                                next ^= 1 << (row * m + col);
                            }
                        }
                        if (!visited.contains(next)) {
                            q.add(next);
                            visited.add(next);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}