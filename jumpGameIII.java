class jumpGame {
    //BFS
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[arr.length];
        int idx1 = 0, idx2 = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            if (arr[cur] == 0) return true;
            int next1 = cur + arr[cur];
            int next2 = cur - arr[cur];
            if (next1 >= 0 && next1 < n && !visited[next1]) {
                q.add(next1);
            }
            if (next2 >= 0 && next2 < n && !visited[next2]) {
                q.add(next2);
            }
        }
        return false;
    }
    //DFS
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) return false;
        if (arr[start] == 0) return true;
        // flag for visited
        arr[start] = -arr[start];
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}