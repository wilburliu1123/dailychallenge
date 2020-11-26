class inorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // there is a right subtree exist, return the leftest child in that right subtree
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // no right subtree, return the parent node in inorder way.
        int inorder = Integer.MAX_VALUE;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            // go to most left child node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (inorder == p.val) {
                return root;
            }
            inorder = root.val;
            root = root.right;
        }
        return null;
    }
}

class wallsAndGates {
    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] gate = q.poll();
            int pos_x = gate[0];
            int pos_y = gate[1];
            for (int k = 0; k < 4; k++) {
                int x = pos_x + dir[k][0];
                int y = pos_y + dir[k][1];
                if (x < 0 || x > m - 1 || y < 0 || y > n - 1) {
                    continue;
                } else {
                    if (rooms[x][y] == INF) {
                        rooms[x][y] = rooms[pos_x][pos_y] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}