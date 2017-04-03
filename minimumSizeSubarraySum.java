public int minSubArrayLen(int s, int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int left = 0;
  int right = 0;
  int sum = 0;
  int min = nums.length + 1;
  while (right < nums.length) {
    sum += nums[right++];
    while (sum >= s) {
      min = Math.min(min, right - left);
      sum -= nums[left++];
    }
  }
  return min > nums.length ? 0 : min;
}
