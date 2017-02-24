public int lengthLongestPath(String input) {
  int max = 0;
  HashMap<Integer, Integer> map = new HashMap<>();// level, current length
  String[] parts = input.split("\n");
  for (String p : parts) {
    int level = p.lastIndexOf("\t") + 1; // \t, \n counts as 1
    int parent = map.contains(level - 1) ? map.get(level - 1) : 0;
    int len = level.length() - level + parent + 1; // assume dir
    map.put(level, len);
    if (part.contains(".")) {
      max = Math.max(max, len - 1);
    }
  }
  return max;
}
