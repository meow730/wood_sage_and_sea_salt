public int numDecodings(String s) {
  int[] cnt = new int[s.length() + 1];
  // back to front!!!
  cnt[s.length()] = 1;
  cnt[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
  for (int i = s.length() - 2; i >= 0; i--) {
    if (s.chatAt(i) == '0') continue;
    int num = s.charAt(i) - '0' + (s.chatAt(i + 1)) * 10;
    cnt[i] = (num <= 26 ? cnt[i + 2] : 0) + cnt[i + 1];
  }
  return cnt[0];
}
