public List<String> removeInvalidParentheses(String s) {
  int rmL = 0; // max removal cnt (
  int rmR = 0; // max removal cnt )
  for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == '(') {
      rmL++;
    } else if (s.charAt(i) == ')') {
      if (rmL > 0) {
        rmL--;
      } else {
        rmR++;
      }
    }
  }
  Set<String> set = new HashSet<>();
  dfs(s, 0, new StringBuilder(), set, rmL, rmR, 0);
  return new ArrayList<String>(set);
}

private void dfs(String s, int i, StringBuilder sb, Set<String> set, int l, int r, int open) {
  if (l < 0 || r < 0 || open < 0) return;
  if (i == s.length()) {
    if (l == 0 && r == 0 && open == 0) {
      set.add(sb.toString());
    }
    return;
  }
  char c = s.charAt(i);
  int length = sb.length();
  if (c == '(') {
    dfs(s, i + 1, sb, set, l - 1, r, open); // remove c 
    dfs(s, i + 1, sb.append(c), set, l, r, open + 1); // keep c 
  } else if (c == ')') {
    dfs(s, i + 1, sb, set, l, r - 1, open); // remove c 
    dfs(s, i + 1, sb.append(c), set, l, r, open - 1); // keep c 
  } else {
    dfs(s, i + 1, sb.append(c), set, l, r, open);
  }
  sb.setLength(length);
}
