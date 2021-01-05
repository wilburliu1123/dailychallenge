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
}