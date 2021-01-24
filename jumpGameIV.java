class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n - 1) return step;
                List<Integer> neighbors = map.get(arr[cur]);
                neighbors.add(cur-1);
                neighbors.add(cur+1);
                for (int nei : neighbors) {
                    if (nei >= 0 && nei < n && !visited[nei]) {
                        visited[nei] = true;
                        q.add(nei);
                    }
                }
                neighbors.clear();
            }
            step++;
        }
        return 0;
    }
}