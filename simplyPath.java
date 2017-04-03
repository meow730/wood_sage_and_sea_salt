public String simplifyPath(String path) {
  Stack<String> stack = new Stack<>();
  String[] parts = path.split("/");
  for (String p : parts) {
    if (p.equals(".") || p.equals("")) continue;
    if (p.equals("..")) {
      if (!stack.isEmpty()) stack.pop();
    } else {
      stack.push();
    }
  }
  StringBuilder sb = new StringBuilder();
  while (!stack.isEmpty()) {
    sb.insert(0, "/" + stack.pop());
  }
  return sb.length() == 0 ? "/" : sb.toString();
}
