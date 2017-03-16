public List<List<Integer>> verticalOrder(TreeNode root) {
  List<List<Integer>> res = new ArrayList<>();
  if (root == null) return res;
  HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
  Queue<TreeNode> q = new LinkedList<>();
  Queue<Integer> cols = new LinkedList<>();
  q.add(root);
  cols.add(0);
  int min = 0;
  int max = 0;
  while (!q.isEmpty()) {
    TreeNode node = q.poll();
    int col = cols.poll();
    if (!map.containsKey(col)) {
      map.put(col, new ArrayList<Integer>());
    }
    map.get(col).add(node.val);
    if (node.left != null) {
      q.offer(node.left);
      cols.offer(col - 1);
      min = Math.min(min, col - 1);
    }
    if (node.right != null) {
      q.offer(node.right);
      cols.offer(col + 1);
      max = Math.max(max, col + 1);
    }
  }
  for (int i = min; i <= max; i++) {
    res.add(map.get(i));
  }
  return res;
}
// Or compute range first to get rid of HashMap
computeRange(root, 0);
for(int i = min; i <= max; i++) list.add(new ArrayList<>());
// helper
private void computeRange(TreeNode root, int idx){
  if(root == null) return;
  min = Math.min(min, idx);
  max = Math.max(max, idx);
  computeRange(root.left, idx - 1);
  computeRange(root.right, idx + 1);
}
