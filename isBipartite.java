class DFS {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        // use color to record the visited node. If adjacent node has same color, it is not a bipartite
        int[] colors = new int[m];
        for (int i = 0; i < m; i++) {
            // colors[i] == 0 means this node is not connected, thus not a bipartite
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!validColor(graph, colors, color * -1, neighbor)) {
                return false;
            }
        }
        return true;
    }
}


class BFS{
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] colors = new int[m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) continue;
            q.add(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = colors[node] * -1;
                        q.add(neighbor);
                    } else if (colors[neighbor] == colors[node]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}