public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  if (root == null || root == p || root == q) return root;
  TreeNode left = lowestCommonAncestor(root.left, p, q);
  TreeNode right = lowestCommonAncestor(root.right, p, q);
  if (left != null && right != null) return root;
  return left == null ? right : left;
}
// itera
HashMap<TreeNode, TreeNode> map = new HashMap<>(); // node, parent
Stack<TreeNode> stack = new Stack<>();
stack.push(root);
while (!map.containsKey(p) || !map.containsKey(q)) {
  TreeNode cur = stack.pop();
  if (cur.left != null) {
    map.put(cur.left, cur);
    stack.push(cur.left);
  }
  if (cur.right != null) {
    map.put(cur.right, cur);
    stack.push(cur.right);
  }
}
HashSet<TreeNode> set = new HashSet<>();
while (p != null) {
  set.add(p);
  p = map.containsKey(p) ? map.get(p) : null;
}
while (!set.contains(q)) {
  q = map.get(q);
}
return q;

