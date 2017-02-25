public int maxKilledEnemies(char[][] grid) {
  int row = grid.length;
  int col = grid[0].length;
  int max = 0;
  int rowHits = 0;
  int[] colHits = new int[col];// then every row will have the info of prev row 
  for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {
      if (j == 0 || grid[i][j - 1] == 'W') {
        rowHits = 0;
        // no front E, find end E until W
        for (int k = j; k < col && grid[i][k] != 'W'; k++) {
          rowHits += grid[i][k] == 'E' ? 1 : 0;
        }
      }
      if (i == 0 || grid[i - 1][j] == 'W') {
        colHits[j] = 0;
        // no up E, find down E until W
        for (int k = i; k < row && grid[k][j] != 'W'; k++) {
          colHits[j] += grid[k][j] == 'E' ? 1 : 0;
        }
      }
      if (grid[i][j] == '0') {
        max = Math.max(max, rowHits + colHits[j]);
      }
    }
  }
  return max;
}
