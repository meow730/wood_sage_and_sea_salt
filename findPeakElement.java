public int findPeakElement(int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int left = 0;
  int right = nums.length - 1;
  while (left + 1 < right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] < nums[mid + 1]) {
      left =  mid + 1;
    } else {
      right = mid;
    }
  }
  return (left == nums.length - 1 || nums[left] > nums[left + 1]) ? left : right;
}
