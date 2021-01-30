class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
      int n = board.length;
      boolean[] visited = new boolean[n*n+1];
      Queue<Integer> q = new LinkedList<>();
      q.add(1); //starting point
      int res = 0;
      while(!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
          int cur = q.poll();
          if (visited[cur]) continue;
          visited[cur] = true;
          if (cur == n * n) return res;
          for (int j = 1; j <= 6 && cur + j <= n * n; j++) {
            int next = cur + j;
            int value = getboardValue(board,next);
            if (value > 0) {
              next = value;
            }
            if (!visited[next]) q.add(next);
          }
        }
        res++;
      }
      return -1;
    }
    private int getboardValue(int[][] board, int num) {
      int n = board.length;
      int row = (num - 1) / n;
      int x = n - 1 - row;
      int y = row % 2 == 0 ? num - 1 - row * n : n + row * n - num;
      return board[x][y];
    }
}