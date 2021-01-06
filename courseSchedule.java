class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] nodes = new ArrayList[numCourses];
        int[] deg = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) nodes[i] = new ArrayList<Integer>();
        for (int[] edge : prerequisites) {
            nodes[edge[1]].add(edge[0]);
            deg[edge[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (deg[i] == 0) bfs.add(i);
        }
        for (int i = 0; i < bfs.size(); i++) {
            for (int j : nodes[bfs.get(i)]) {
                if (--deg[j] == 0) {
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == numCourses;
    }
    // hashmap solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0], start = prerequisites[i][1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int next : graph.getOrDefault(cur, new ArrayList<>()))
                if (--indegree[next] == 0)
                    q.add(next);
        }
        return count == numCourses;
    }
}