class seqREconstruct {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] indegree = new int[org.length+1];
        if (seqs.size() == 0) return false;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=org.length; i++) graph.put(i, new ArrayList<>());
        for (int i = 0; i < seqs.size(); i++) {
            List<Integer> list = seqs.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (!graph.containsKey(list.get(j))) return false;
                if (j < list.size() - 1) {
                    int destination = list.get(j+1);
                    if (!graph.containsKey(destination)) return false;
                    graph.get(list.get(j)).add(destination);
                    indegree[destination]++;
                }
            }
        }
        // System.out.println(graph);
        // System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            if (q.size() > 1) return false;
            int cur = q.poll();
            res.add(cur);
            for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                if (--indegree[nei] == 0)
                    q.add(nei);
            }
        }
        // System.out.println(res);
        if (res.size() != org.length) return false;
        for (int i = 0; i < res.size(); i++) {
            if (org[i] != res.get(i))
                return false;
        }
        return true;
    }
}