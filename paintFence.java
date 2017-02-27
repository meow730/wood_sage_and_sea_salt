public int numWays(int n, int k) {
  if (n == 0) return 0;
  if (n == 1) return k;
  int p1 = k;
  int p2 = k * k;
  int p3 = 0;
  for (int i = 2; i < n; i++) {
    p3 = (k - 1) * (p1 + p2);
    p1 = p2;
    p2 = p3;
  }
  return p3;
}
// or traditional DP
int[] dp = new int[n + 1];
dp[1] = k;
dp[2] = k * k;
for (int i = 3; i <= n; i++) {
  dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
}
return dp[n];
