public int combinationSum4(int[] nums, int target) {
  int[] dp = new int[target + 1];
  Arrays.sort(nums);
  for (int i = 1; i <= target; i++) {
    for (int n : nums) {
      if (n > i) break;
      if (n == i) {
        dp[i] += 1;
      } else {
        dp[i] += dp[i - n];
      }
    }  
  }
  return dp[target];
}
// 即使不sort 也可以，就是不能多pruning点
public int combinationSum4(int[] nums, int target) {
  int[] comb = new int[target + 1];
  comb[0] = 1;
  for (int i = 1; i < comb.length; i++) {
    for (int j = 0; j < nums.length; j++) {
      if (i - nums[j] >= 0) {
        comb[i] += comb[i - nums[j]];
      }
    }
  }
  return comb[target];
}
