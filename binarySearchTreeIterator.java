public class BSTIterator {

  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    if (root != null) {
      stack.push(root);
      while (root.left != null) {
        stack.push(root.left);
        root = root.left;
      }
    }
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode node = stack.pop();
    int toReturn = node.val;
    if (node.right != null) {
      node = node.right;
      stack.push(node);
      while (node.left != null) {
        stack.push(node.left);
        node = node.left;
      }
    }
    return toReturn;
  }

}
