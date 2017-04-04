public int findTargetSumWays(int[] nums, int S) {
  // sum of pos, sum of neg
  //  p - n = target
  //  p + n + p - n = target + p + n => 2 * p = target + sum_total
  //  p => (target + total) / 2
  //  subset sum problem
  int sum = 0;
  for (int n : nums) {
    sum += n;
  }
  return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (sum + S) >>> 1);
}
private int subsetSum(int[] nums, int target) {
  int[] dp = new int[target + 1]; // 到和i有几种可能
  dp[0] = 1;
  for (int n : nums) {
    for (int i = target; i >= n; i--) {
      dp[i] += dp[i - n];
    }
  }
  return dp[target];
}
