class courseSchedule2{
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0], start = prerequisites[i][1];
            graph.computeIfAbsent(start, x -> new ArrayList<>()).add(end);
            indegree[end]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int[] res = new int[numCourses];
        int i = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[i++] = cur;
            for (int neigh : graph.getOrDefault(cur, new ArrayList<>()))
                if (--indegree[neigh] == 0) q.offer(neigh);
        }
        return i == numCourses ? res : new int[0];
    }
}