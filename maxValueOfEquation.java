class maxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> q = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        q.add(points[0]);
        for (int i = 1; i < points.length; i++) {
            while (!q.isEmpty() && Math.abs(q.peekFirst()[0] - points[i][0]) > k) q.pollFirst();
            if (!q.isEmpty()) {
                // System.out.println("x[i] " + q.peekFirst()[0] + " x[j]: " + points[i][0] + " y[i]: " + q.peekFirst()[1] + " y[j]: " + points[i][1]);
                // System.out.println(q);
                res = Math.max(res, q.peekFirst()[1] + points[i][1] + Math.abs(q.peekFirst()[0] - points[i][0]));
                // System.out.println("res: " + res);
            }
            while (!q.isEmpty() && (q.peekLast()[1] - q.peekLast()[0]) < (points[i][1]-points[i][0])) q.pollLast();

            q.offerLast(points[i]);
        }
        return res;
    }
}