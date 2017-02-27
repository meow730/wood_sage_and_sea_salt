private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
public boolean hasPath(int[][] maze, int[] start, int[] destination) {
  // bfs
  int rows = maze.length;
  int cols = maze[0].length;
  boolean[][] vis = new boolean[rows][cols];
  vis[start[0]][start[1]] = true;
  Queue<Integer> q = new LinkedList<>();
  q.offer(start[0] * cols + start[1]);
  while (!q.isEmpty()) {
    int cur = q.poll();
    int x = cur / cols;
    int y = cur % cols;
    for (int[] d : dirs) {
      int i = x + d[0];
      int j = y + d[1];
      // one direction all the way
      while (i >= 0 && i < rows && j >= 0 && j < cols && maze[i][j] == 0) {
        i += d[0];
        j += d[1];
      }
      // back to last qualified point
      i -= d[0];
      j -= d[1];
      if (vis[i][j]) continue;
      vis[i][j] = true;
      if (i == destination[0] && j == destination[1]) {
        return true;
      }
      q.offer(i * cols + j);
    }
  }
  return false;
}
