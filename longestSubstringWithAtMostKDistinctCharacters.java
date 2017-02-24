public int lengthOfLongestSubstringKDistinct(String str, int k) {
  HashMap<Character, Integer> map = new HashMap<>();
  // sliding win solu
  int head = 0;
  int max = 0;
  for (int i = 0; i < s.length(); i++) { 
    if (map.isEmpty() || !map.containsKey(s.charAt(i))) {
      map.put(s.charAt(i), 1);
    } else {
      map.put(s.charAt(i), map.get(s.charAt(i) + 1));
    }
    while (map.size() > k) {
      char c = s.charAt(head);
      map.put(c, map.get(c - 1));
      if (map.get(c) == 0) {
        map.remove(c);
      }
      head++;
    }
    max = Math.max(max, i - head + 1);
  }
  return max;
}
