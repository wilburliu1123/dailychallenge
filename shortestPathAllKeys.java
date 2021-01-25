class ShortestPathAllKeys {
    int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int shortestPathAllKeys(String[] grid) {
        StringBuilder sb = new StringBuilder();
        int n = grid.length, m = grid[0].length(), keyCount = 0, lockCount = 0;
        // System.out.println("n: " + n + " m " + m);
        for (String s : grid) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c - 'a' >= 0 && c-'a' < 26) {
                    keyCount++;
                } else if (c - 'A' >= 0 && c - 'A' <= 25) {
                    lockCount++;
                }
            }
            sb.append(s);
        }
        String startStr = sb.toString();

        int start = startStr.indexOf('@');
        State startState = new State(start / m, start % m, 0);
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(startState);
        visited.add(start / m + " " + start % m + " " + 0);
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                State cur = q.poll();
                if (cur.key == (1 << keyCount) - 1) return step;
                for (int[] dir : dirs) {
                    int i = cur.x + dir[0], j = cur.y + dir[1], key = cur.key;
                    if (i >= 0 && i < n && j >= 0 && j < m && startStr.charAt(i*m+j) != '#') {
                        char c = startStr.charAt(i*m+j);
                        if (c - 'A' >= 0 && c - 'A' < 26) {
                            //it is a lock, check if we have the key
                            if ((key >> (c - 'A') & 1) == 0) {
                                continue;
                            }
                        } else if (c - 'a' >= 0 && c - 'a' < 26) {
                            // it is a key
                            key |= (1 << (c - 'a'));
                        }
                        if (visited.add(i + " " + j + " " + key)) q.add(new State(i, j, key));
                    }
                }
            }
            step++;
        }
        return -1;
    }
    class State {
        int x, y, key;
        public State(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
}