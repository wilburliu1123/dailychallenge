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
}