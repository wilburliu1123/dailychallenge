class SortItemsbyGroupDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> next = new HashMap<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i=0; i<n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        int[] nextItemIndegree = new int[n];
        int[] groupIndegree = new int[m];
        // get next graph based on groups
        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            for (int j : beforeList) {
                if (group[i] != group[j]) {
                    groups.computeIfAbsent(group[j], x -> new ArrayList<>()).add(group[i]);
                    groupIndegree[group[i]]++;
                }
                next.computeIfAbsent(j, x -> new ArrayList<>()).add(i);
                nextItemIndegree[i]++;
            }
        }
        // System.out.println(next);
        // System.out.println(groups);
        // System.out.println("groupIndegree: " + Arrays.toString(groupIndegree));
        // System.out.println("nextIndegree: " + Arrays.toString(nextItemIndegree));
        // System.out.println("n: " + n + " m: " + m);
        int[] sortedItem = topologicalSort(next, nextItemIndegree, n);
        int[] sortedGroup = topologicalSort(groups, groupIndegree, m);

        if (sortedItem.length != n || sortedGroup.length != m) return new int[0];
        List<Integer> res = new ArrayList<>();
        List<Integer>[] temp = new ArrayList[m];
        for (int i = 0; i < m; i++) temp[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp[group[sortedItem[i]]].add(sortedItem[i]);
        }
        // System.out.println("sortedItem: " + Arrays.toString(sortedItem));
        // System.out.println("sortedGroup: " + Arrays.toString(sortedGroup));
        // System.out.println("temp: " + Arrays.toString(temp));
        int[] ans = new int[n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j : temp[sortedGroup[i]])
                ans[idx++] = j;
        }
        return ans;
    }
    private int[] topologicalSort(Map<Integer, List<Integer>> next, int[] indegree, int n) {
        int[] res = new int[n];
        Queue<Integer> q = new LinkedList<>();
        // System.out.println("indegree: " + Arrays.toString(indegree));
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        // System.out.println("next: " + next);
        // System.out.println("q: " + q);
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[count++] = cur;
            for (int i : next.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        // System.out.println("n: " + n);
        // System.out.println("Res: " + Arrays.toString(res));
        return count == n ? res : new int[0];
    }
}