private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
public void wallsAndGates(int[][] rooms) {
  // BFS
  int m = rooms.length;
  int n = rooms[0].length;
  Queue<Integer> q = new LinkedList<>();
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      if (rooms[i][j] == 0) q.offer(i * n + j);
    }
  }
  while (!q.isEmpty()) {
    int cur = q.poll();
    int x = cur / n;
    int y = cur % n;
    for (int[] d : dirs) {
      int i = x + d[0];
      int j = y + d[1];
      if (i >= 0 && j >= 0 && i < m && j < n
          && rooms[i][j] == Integer.MAX_VALUE) {
        rooms[i][j] = rooms[x][y] + 1;
        q.offer(i * n + j);
      }
    }
  }
}
