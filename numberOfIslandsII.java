// UNION operation is only changing the root parent so the running time is O(1).
// FIND operation is proportional to the depth of the tree. If N is the number
// of points added, the average running time is O(logN), and a sequence of 4N
// operations take O(NlogN). If there is no balancing, the worse case could be O(N^2).
private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
public List<Integer> numIslands2(int m, int n, int[][] positions) {
  // count the number of islands after each addLand operation
  // Union & find
  // record tree pre island, track root idx
  List<Integer> res = new ArrayList<>();
  int[] roots = new int[m * n];// m => row, n => col
  int cnt = 0;
  Arrays.fill(roots, -1);
  for (int[] p : positions) {
    int idx = p[0] * n + p[1];
    roots[idx] = idx; // assume it is an isolated new island, root idx is self
    cnt++;
    for (int[] d : dir) {
      int x = p[0] + d[0];
      int y = p[1] + d[1];
      int i = x * n + y; // the neighbor
      if (x < 0 || y < 0 || x >= m || y >= n || roots[p] == -1) continue;
      int newRoot = findIslandRoot(roots, i);
      if (newRoot != root) { // it belongs to an existing island
        // Union
        roots[idx] = newRoot;
        root = newRoot;
        cnt--;
      }
    }
    res.add(cnt);
  }
  return res;
}
private int findIslandRoot(int[] roots, int i) {
  while (roots[i] != i) {
    // roots[i] = roots[roots[i]]; // enhance: path compression
    i = roots[i];
  }
  return i;
}
