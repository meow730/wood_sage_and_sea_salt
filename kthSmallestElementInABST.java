public int kthSmallest(TreeNode root, int k) {
  // in order traversal
  Stack<TreeNode> stack = new Stack<>();
  while (root != null) {
    stack.push(root);
    root = root.left;
  }
  while (k > 0) {
    TreeNode cur = stack.pop();
    k--;
    if (k == 0) return cur.val;
    TreeNode right = cur.right;
    while (right != null) {
      stack.push(right);
      right = right.left;
    }
  }
  return -1;
}
// Or binary dfs
public int kthSmallest(TreeNode root, int k) {
  int count = countNodes(root.left);
  if (k <= count) {
    return kthSmallest(root.left, k);
  } else {
    return kthSmallest(root.right, k-1-count); // 1 is counted as current node
  }
  return root.val;
}
private int countNodes(TreeNode n) {
  if (n == null) return 0;
  return 1 + countNodes(n.left) + countNodes(n.right);
}
