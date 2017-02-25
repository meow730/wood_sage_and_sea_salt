public void wiggleSort(int[] nums) {
  // a <= b >= c <= d
  // odd nums[i] >= nums[i -1]
  // even nums[i] <= nums[i - 1]
  for (int i = 0; i < nums.length; i++) {
    if (i % 2 == 1 && nums[i] < nums[i - 1]) {
      swap(nums, i);
    } else if (i > 0 && i % 2 == 0 && nums[i] > nums[i - 1]) {
      swap(nums, i);
    }
  }
}

private void swap(int[] nums, int x) {
  int temp = nums[x];
  nums[x] = nums[x - 1];
  nums[x - 1] = temp;
}
