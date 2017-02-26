public boolean isStrobogrammatic(String num) {
  HashMap<Character, Charater> map = new HashMap<>();
  map.put('0', '0');
  map.put('1', '1');
  map.put('8', '8');
  map.put('6', '9');
  map.put('9', '6');
  int left = 0;
  int right = num.length() - 1;
  while (left <= right) {
    if (!map.containsKey(left)) return false;
    if (map.get(left) != num.charAt(right)) return false;
    left++;
    right--;
  }
  return true;
}
