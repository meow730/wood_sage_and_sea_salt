public boolean isValidBST(TreeNode root) {
  if (root == null) return true;
  Stack<TreeNode> stack = new Stack<>();
  TreeNode prev = null;
  while (root != null || !stack.isEmpty()) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    root = stack.pop();
    if (prev != null && root.val <= prev.val) return false;
    prev = root;
    root = root.right;
  }
  return true;
}
// RECUR
public boolean isValidBST(TreeNode root) {
  return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
    
public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
  if (root.val >= maxVal || root.val <= minVal) return false;
  return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
}

