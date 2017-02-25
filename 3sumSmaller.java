public int threeSumSmaller(int[] nums, int target) {
  int cnt = 0;
  Arrays.sort(nums);
  for (int i = 0; i < nums.length - 2; i++) {
    int sum = target - nums[i];
    int left = i + 1;
    int right = nums.length - 1;
    while (left < right) {
      if (nums[left] + nums[right] < sum) {
        cnt += right - left;
        left++;
      } else if (nums[left] + nums[right] > sum) {
        right--;
      }
    }
  }
  return cnt;
}
