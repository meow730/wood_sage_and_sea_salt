public int numberOfPatterns(int m, int n) {
  // 1 2 3
  // 4 5 6
  // 7 8 9
  int[][] skip = new int[10][10];// number would be skipped if i => j
  skip[1][3] = skip[3][1] = 2;
  skip[1][7] = skip[7][1] = 4;
  skip[7][9] = skip[9][7] = 8;
  skip[9][3] = skip[3][9] = 6;
  skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
  skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = 5;
  boolean[] visited = new boolean[10];
  int cnt = 0;
  for (int i = m; i <= n; i++) {
    cnt += dfs(skip, visited, 1, i - 1) * 4;// 1, 7, 3, 9
    cnt += dfs(skip, visited, 2, i - 1) * 4;// 2, 4, 6, 8
    cnt += dfs(skip, visited, 5, i - 1); // 5
  }
  return cnt;
}
private int dfs(int[][] skip, boolean[] visited, int curVal, int remain) {
  if (remain < 0) return 0;
  if (remain == 0) return 1;
  visited[curVal] = true;
  int cnt = 0;
  for (int i = 1; i <= 9; i++) {
    if (!visited[i] && (skip[curVal][i] == 0 || visited[skip[curVal][i]])) {
      // no skip worries or the potential skip is already visited
        cnt += dfs(skip, visited, i, remain - 1);
    }
  }
  visited[curVal] = false;
  return cnt;
}
