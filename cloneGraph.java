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