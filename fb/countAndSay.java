public String countAndSay(int n) {
  StringBuilder cur = new StringBuilder("1");
  StringBuilder pre;
  while (n > 1) {
    pre = cur;
    cur = new StringBuilder();
    char say = pre.charAt(0);
    int cnt = 1;
    for (int i = 1; i < pre.length(); i++) {
      if (pre.charAt(i) == say) {
        cnt++;
      } else {
        cur.append(cnt).append(say);
        cnt = 1;
        say = pre.charAt(i);
      } 
    }
    cur.append(cnt).append(say);
    n--; 
  }
  return cur.toString();
}
