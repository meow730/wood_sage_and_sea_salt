public List<List<Integer>> levelOrder(TreeNode root) {
  List<List<Integer>> ans = new ArrayList<>();
  if (root == null) return ans;
  Queue<TreeNode> q = new LinkedList<>();
  q.offer(root);
  while (!q.isEmpty()) {
    int level = q.size();
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < level; i++) {
      TreeNode cur = q.poll();
      l.add(cur.val);
      if (cur.left != null) q.offer(cur.left);
      if (cur.right != null) q.offer(cur.right);
    }
    ans.add(l);
  }
  return ans;
}
