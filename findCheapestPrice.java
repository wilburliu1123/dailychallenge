class findcheapestPrice {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        // map -> (source, [destination, price])
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) map.put(flights[i][0], new HashMap<>());
            map.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }
        pq.add(new int[] {src, K + 1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int source = cur[0];
            int stops = cur[1];
            int price = cur[2];
            if (source == dst) return price;
            if (stops > 0) {
                Map<Integer, Integer> nextStop = map.getOrDefault(source, new HashMap<>());
                for (int next : nextStop.keySet()) {
                    pq.add(new int[] {next, stops - 1, price + nextStop.get(next)});
                }
            }
        }
        return -1;
    }
}