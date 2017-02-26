private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
public List<int[]> pacificAtlantic(int[][] matrix) {
  // corner cases
  List<int[]> res = new ArrayList<>();
  int rows = matrix.length;
  int cols = matrix[0].length;
  boolean[][] pacific = new boolean[rows][cols];
  boolean[][] altantic = new boolean[rows][cols];
  // bfs
  Queue<int[]> pq = new LinkedList<>();
  Queue<int[]> ap = new LinkedList<>();
  for (int i = 0; i < rows; i++) {
    pq.offer(new int[]{i, 0});
    aq.offer(new int[]{i, cols - 1});
    pacific[i][0] = true;
    altantic[i][cols - 1] = true;
  }
  for (int i = 0; i < cols; i++) {
    pq.offer(new int[]{0, i});
    aq.offer(new int[]{rows - 1, i});
    pacific[0][i] = true;
    altantic[rows - 1][i] = true;
  }
  bfs(matrix, pacific, pq);
  bfs(matrix, altantic, aq);
  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; i++) {
      if (pacific[i][j] && altantic[i][j]) {
        res.add(new int[]{i, j});
      }
    }
  }
}
private void bfs(int[][] matrix, boolean[][] vis, Queue<int[]> q) {
  while (!q.isEmpty()) {
    int[] cur = q.poll();
    for (int[] d : dirs) {
      int x = cur[0] + d[0];
      int y = cur[1] + d[1];
      if (x < 0 || x >= rows || y < 0 || y >= cols || vis[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
        continue;// note: flow to
      }
      vis[x][y] = true;
      q.offer(new int[]{x, y});
    }
  }
}
