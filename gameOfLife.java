public void gameOfLife(int[][] board) {
  // live
  // < 2 live => dead
  // 2, 3 => live
  // > 3 => dead
  // dead
  // = 3 => live
  // 8 neighbors
  for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
      int liveAround = countLives(board, i, j);
      if (board[i][j] == 1 && liveAround >= 2 && liveAround <= 3) {
        board[i][j] = 3;
      } else if (board[i][j] == 0 && liveAround == 3) {
        board[i][j] = 2;
      }
    }
  }
  for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
      board[i][j] >>= 1; // use 2nd bit info 
    }
  } 
}
private int countLives(int[][] grid, int i, int j) {
  int lives = 0;
  if (i > 0) lives += grid[i - 1][j] & 1;
  if (i < grid.length - 1) lives += grid[i + 1][j] & 1;
  if (j > 0) lives += grid[i][j - 1] & 1;
  if (j < grid[0].length - 1) lives += grid[i][j + 1] & 1;
  return lives;
}
