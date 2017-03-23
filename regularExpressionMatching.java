public boolean isMatch(String s, String p) {
  // . => 1
  // * >= 0 preceding!! element
  boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
  // dp[i][j] => char i in s is matching char j in p
  dp[0][0] = true;
  for (int i = 1; i < p.length(); i++) {
    if (p.charAt(i) == '*' && dp[0][i - 1]) {
      dp[0][i + 1] = true;
    }
  }
  for (int i = 0; i < s.length(); i++) {
    for (int j = 0; j < p.length(); j++) { 
      if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
        // single match only
        dp[i + 1][j + 1] = dp[i][j];
      } else if (p.charAt(j) == '*') { // Earliest start idx : 1
        // * is always repeating or zero prev element in p,
        // get rid of prev, * is as 0
        // use prev once, * is as 1
        // use more than 1 prev, * is as multi
        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
          // prev doesn't match, get rid of prev
          dp[i + 1][j + 1] = dp[i + 1][j - 1]; // index: i, j - 2
        } else {
          // prev match
          // i - 1, j ; i, j - 1; i, j - 2
          // multi; 1; 0
          dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
        }
      }
    }
  }
  return dp[s.length()][p.length()];
}
