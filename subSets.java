public List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> res = new ArrayList<>();
  if (nums == null || nums.length == 0) return res;
  Arrays.sort(nums);
  backtrack(nums, res, 0, new ArrayList<Integer>());
  return res;
}
private backtrack(int[] nums, List<List<Integer>> res, int start, ArrayList<Integer> entry) {
  res.add(new ArrayList<Integer>(entry));
  for (int i = start; i < nums.length; i++) {
    entry.add(nums[i]);
    backtrack(nums, res, i + 1, entry);
    entry.remove(entry.size() - 1);
  }
}

