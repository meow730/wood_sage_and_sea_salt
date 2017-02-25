public int longestConsecutive(TreeNode root) {
  private int max;
  if (root == null) {
    return 0;
  }
  // cannot use recurive because the node itself may not be
  // the starting point
  dfs(root, root.val, 0);
  return max;
}
private void dfs(TreeNode root, int target, int len) {
  if (root == null) {
    return;
  } else if (root.val == target) {
    len++;
  } else {
    len = 1; // new start
  }
  max = Math.max(max, len);
  dfs(root.left, root.val + 1, len);
  dfs(root.right, root.val + 1, len);
}
