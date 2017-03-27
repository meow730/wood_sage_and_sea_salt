public boolean exist(char[][] board, String word) {
  if (word.length() == 0) return true;
  boolean[][] vis = new boolean[board.length][board[0].length];
  for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[0].length; j++) {
      if (dfs(board, i, j, word, 0, vis)) return true;
    }
  }
  return false;
}
private boolean dfs(char[][] bd, int i, int j, String s, int idx, boolean[][] vis) {
  if (idx == s.length()) return true;
  if (i < 0 || i >= bd.length || j < 0 || j >= bd[0].length) return false;
  if (vis[i][j] || s.charAt(idx) != bd[i][j]) return false;
  vis[i][j] = true;
  boolean check = dfs(bd, i + 1, j, s, idx + 1, vis) ||
    dfs(bd, i - 1, j, s, idx + 1, vis) || 
    dfs(bd, i, j + 1, s, idx + 1, vis) || 
    dfs(bd, i, j - 1, s, idx + 1, vis);
  vis[i][j] = false;
  return check;
}
// if no extra space
// board[i][j] ^= 256; // char < 128, 256: 1000,0000, +128, then -128
