public char findTheDifference(String s, String t) {
  // naive way: have alp array 26 to track count
  // XOR => turn all same into zero!
  char c = t.charAt(t.length() - 1);
  for (int i = 0; i < s.length(); i++) {
    c ^= s.charAt(i);
    c ^= t.charAt(i);
  }
  return c;
}
