public int numSquares(int n) {
  // dp solu
  int[] dp = new int[n + 1];
  dp[0] = 0;
  dp[1] = 1;
  for (int i = 2; i <= n; i++) {
    dp[i] = i;
    for (int k = 1; k * k <= i; k++) {
      dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
    }
  }
  return dp[n];
}
// BFS Solu
public int numSquares(int n) {
  // n <= 0 return 0
  int steps = 0;
  Queue<Integer> deck = new LinkedList<>();
  deck.offer(n);
  while (!deck.isEmpty()) {
    Queue<Integer> next =  new LinkedList<>();
    int size = deck.size();
    steps++;
    for (int i = 0; i < size; i++) {
      int cur = deck.poll();
      for (int k = (int) Math.sqrt(cur); k > 0; k--) {
        if (cur == k * k) return steps;
        next.offer(cur - k * k);
      }
    }
    deck = next;
  }
  return 0;
}
