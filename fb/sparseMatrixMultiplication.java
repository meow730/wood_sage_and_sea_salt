public int[][] multiply(int[][] A, int[][] B) {
  int[][] ans = new int[A.length][B[0].length];
  for (int i = 0; i < A.length; i++) {
    for (int j = 0; j < A[0].length; j++) {
      if (A[i][j] != 0) {
        for (int k = 0; k < B[0].length; k++) {
          if (B[j][k] != 0) {
            ans[i][k] += A[i][j] * B[j][k];
          }
        }
      }
    }
  }
  return ans;
}
// sparse
public int[][] multiply(int[][] A, int[][] B) {
  int[][] ans = new int[A.length][B[0].length];
  HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
  // use a map tp track none zero elements in B
  for (int i = 0; i < B.length; i++) {
    map.put(i, new HashMap<Integer, Integer>());
    for (int j = 0; j < B[0].length; j++) {
      if (B[i][j] != 0) {
        map.get(i).put(j, B[i][j]);
      }
    }
  }
  for (int i = 0; i < A.length; i++) {
    for (int j = 0; j < A[0].length; j++) {
      if (A[i][j] != 0) {
        for (Integer k : map.get(j).keySet()) {
          ans[i][k] += A[i][j] * map.get(j).get(k);
        }  
      }
    }
  }
  return ans;
}
