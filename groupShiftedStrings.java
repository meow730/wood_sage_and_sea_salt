public List<List<String>> groupStrings(String[] strings) {
  HashMap<String, List<String>> map = new HashMap<>();
  for (String s : strings) {
    String code  = getCode(s);
    if (!map.containsKey(code)) {
      map.put(code, new ArrayList<String>());
    }
    map.get(code).add(s);
  }
  List<List<String>> ans = ArrayList<List<String>>();
  for (String k : map.keySet()) {
    List<String> list = map.get(k);
    Collections.sort(list);
    ans.add(list);
  }
  return ans;
}
private String getCode(String s) {
  StringBuilder sb = new StringBuilder();
  sb.append("#");
  for (int i = 1; i < s.length(); i++) {
    int num = ((s.charAt(i) - s.charAt(i - 1)) + 26) % 26;
    ab.append(num).append("#");
  }
  return sb.toString();
}
