public List<String> letterCombinations(String digits) {
  // corner case
  String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  List<String> list = new ArrayList<>();
  // HERE, Another way
  dfs(digits, 0, map, list, new StringBuilder());
  return list;
}
private void dfs(String s, int i, String[] map, List<String> list, StringBuilder sb) {
  // backtracks
  if (sb.length() == s.length()) {
    res.add(sb.toString());
    return;
  }
  char[] chars = map[s.charAt(i) - '0'].toCharArray();
  for (char c : chars) {
    sb.append(c);
    dfs(s, i + 1, map, list, sb);
    sb.deleteCharAt(sb.length() - 1);
  }
}
// HERE Another way, bfs
LinkedList<String> queue = new LinkedList<>();
queue.add("");
for (int i = 0; i < digits.length(); i++) {
  int n = digits.charAt(i) - '0';
  while (queue.peek().length() == i) { // still old length exists
    String prev = queue.poll();
    char[] chars = map[n].toCharArray();
    for (char c : chars) {
      queue.offer(prev + c);
    }
  }
}
return queue;
