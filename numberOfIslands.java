private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
public int numIslands(char[][] grid) {
   // corner case
   int cnt = 0;
   for (int i = 0; i < grid.length; i++) {
     for (int j = 0; j < grid[0].length; i++) {
       if (grid[i][j] == '1') {
         cnt++;
         dfs(grid, i, j);
       }
     }
   }
   return cnt;
}
private void dfs(char[][] grid, int x, int y) {
  if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
  grid[x][y] = '0';
  for (int[] d : dirs) {
    dfs(grid, x + d[0], y + d[1]);
  }
}
