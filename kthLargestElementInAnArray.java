// Time complexity = O(n)
// Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.
public int findKthLargest(int[] nums, int k) {
  return helper(nums, 0, nums.length - 1, nums.length - k);
}
// find kth smallest
private int helper(int[] nums, int start, int end, int k) {
  if (start > end) return Integer.MAX_VALUE;

  int pivot = nums[end];
  int left = start;
  for (int i = start; i < end; i++) {
    if (nums[i] <= pivot) {
      // move all nums smaller than pivot to the left
      swap(nums, left++, i);
    }
  }
   swap(nums, left, end);

   if (k == left) {
    return pivot;
   } else if (k < left) {
    return helper(nums, start, left - 1, k);
   } else {
    return helper(nums, left + 1, end, k);
   }
}
private void swap(int[] nums, int i, int j) {
  int temp = nums[i];
  nums[i] = nums[j];
  nums[j] = temp;
}
