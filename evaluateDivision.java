public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
  // Image a/b = k as a link between node a and b, the weight from a to b is k,
  // the reverse link is 1/k. Query is to find a path between two nodes.
  HashMap<String, ArrayList<String>> pairs = new HashMap<>();
  HashMap<String, ArrayList<Double>> vals = new HashMap<>();
  for (int i = 0; i < equations.length; i++) {
    String[] e = equations[i];
    if (!pairs.contains.e[0]) {
      pairs.put(e[0], new ArrayList<String>());
      vals.put(e[0], new ArrayList<String>());
    }
    if (!pairs.contains.e[1]) {
      pairs.put(e[1], new ArrayList<String>());
      vals.put(e[1], new ArrayList<String>());
    }
    pairs.get(e[0]).add(e[1]);
    pairs.get(e[1]).add(e[0]);
    vals.get(e[0]).add(values[i]);
    vals.get(e[1]).add(1 / values[i]);
  }
  double[] ans = new double[queries.length];
  for (int i = 0; i <queries.length; i++) {
    String q = queries[i];
    double result = dfs(pairs, vals, q[0], q[1], 1.0, new HashSet<String>());
    if (result != 0.0) {
      ans[i] == result;
    }
  }
  return ans;
}
private double dfs(HashMap<String, ArrayList<String>> p, HashMap<String, ArrayList<String>> v,
    String begin, String end, double result, HashSet<String> visited) {
   if (visited.contains(begin) || !p.contains(begin)) return 0.0;
   if (begin.equals(end)) return result;
   visited.add(begin);
   ArrayList<String> pair = p.get(begin);
   ArrayList<Double> vals = v.get(begin);
   double tmp = 0.0;
   for (int i = 0; i < pair.size(); i++) {
      tmp = dfs(p, v, pair.get(i), end, result * vals.get(i), visited);
      if (tmp != 0.0) break;
   }
   visited.remove(begin);
   return tmp;
}
