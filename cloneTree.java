class cloneTreeAndGraph {
    // DFS for tree
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneTree(Node root) {
        if (root == null) {
            return root;
        }
        if (visited.containsKey(root)) {
            return visited.get(root);
        }
        Node copy = new Node(root.val, new ArrayList<>());
        visited.put(copy, root);
        for (Node child : root.children) {
            copy.children.add(cloneTree(child));
        }
        return copy;
    }
    // Below is for graph
    private HashMap<Node, Node> map = new HashMap<>();
    private Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            //recursively add neighbors to current cloneNode
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
    // maximum Minimum path (priorityQueue search)
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[] x_dir = new int[]{1, -1, 0, 0};
        int[] y_dir = new int[]{0, 0, 1, -1};
        PriorityQueue<int[]> heap = new PriorityQueue<>((b, a) -> A[a[0]][a[1]] - A[b[0]][b[1]]);
        boolean[][] visited = new boolean[m][n];
        heap.add(new int[] {0, 0, A[0][0]});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            visited[curr[0]][curr[1]] = true;
            for (int i = 0; i < 4; i++) {
                int row = curr[0] + x_dir[i];
                int col = curr[1] + y_dir[i];
                if (row == m - 1 && col == n - 1) {
                    return Math.min(curr[2], A[row][col]);
                }
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    int val = A[row][col];
                    heap.add(new int[]{row, col, Math.min(curr[2], val)});
                }
            }
        }
        return 0;
    }

}