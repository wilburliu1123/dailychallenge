class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> next = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] cur : prerequisites) {
            int start = cur[0], end = cur[1];
            next.computeIfAbsent(start, x -> new HashSet<>()).add(end);
            indegree[end]++;
        }
        // System.out.println(next);
        // System.out.println(Arrays.toString(indegree));
        Map<Integer, Set<Integer>> preReq = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            preReq.computeIfAbsent(i, x -> new HashSet<>()).add(i);
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Boolean> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : next.getOrDefault(cur, new HashSet<>())) {
                for (int j : preReq.get(cur)) {
                    Set<Integer> set = preReq.get(i);
                    set.add(j);
                    preReq.put(i, set);
                }
                if (--indegree[i] == 0)
                    q.add(i);
            }
        }
        for (int[] row : queries) {
            int start = row[0], end = row[1];
            res.add(preReq.get(end).contains(start));
        }
        return res;
    }
}