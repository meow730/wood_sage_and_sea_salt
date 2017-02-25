public List<String> findMissingRanges(int[] nums, int lower, int upper) {
  // corner case : nums.length == 0
  List<String> list = new ArrayList<>();
  int pre = lower - 1;
  for (int i = 0; i <= nums.length; i++) {
    int cur = i == nums.length ? upper + 1  : nums[i];// mocking cur - 1
    if (pre + 2 == cur) { // missing a single
      list.add(cur - 1 + "");
    } else if (pre + 2 < cur) {
      list.add(pre + 1 + "->" + cur - 1);
    }
    prev = cur
  }
  return list;
}
