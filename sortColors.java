public void sortColors(int[] nums) {
  // 0, 1, 2
  int zero = 0;// end zero idx
  int two = nums.length - 1;// start two idx

  for (int i = 0; i <= two; i++) {
    if (nums[i] == 0 && i > zero) {
      swap(nums, i, zero);
      i--;
      zero++;
    } else if (nums[i] == 2 && i < second) {
      swap(nums, i, two);
      i--;
      two--;
    }
  }
}
private void swap(int[] arr, int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
