class minimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int[][] visited = new int[8001][2];
        if (x == 0) return 0;
        int max = 0;
        // Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            // set.add(i);
            visited[i][0] = -1;
            visited[i][1] = -1;
            max = Math.max(max, i);
        }
        int limit = Math.max(max, x) + b;
        // System.out.println(limit);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int l = 0; l < size; l++) {
                Pair<Integer,Integer> cur = q.poll();
                int i = cur.getKey();
                int k = cur.getValue();
                // within limit and not visited(not forbidden either)
                if (i <= limit && visited[i + a][0] == 0) {
                    visited[i + a][0] = 1;
                    q.add(new Pair(i + a, 0));
                    if (i + a == x) return step;
                }
                if (k == 0) {
                    if (i - b >= 0 && visited[i - b][1] == 0) {
                        visited[i - b][1] = 1;
                        q.add(new Pair(i - b, 1));
                        if (i - b == x) return step;
                    }
                }
            }
        }
        return -1;
    }
}