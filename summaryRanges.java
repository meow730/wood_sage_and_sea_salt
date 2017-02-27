public List<String> summaryRanges(int[] nums) {
  List<String> list = ArrayList<>();
  int begin = nums[0];
  int end = begin;
  for (int n : nums) {
    if (n == end + 1) {
      end = n;
    } else {
      String str = begin == end ? begin + "" : begin + "->" + end;
      list.add(str);// a break found, add prev tracker

      begin = n;
      end = begin;
    }
  }
  String s = begin == end ? begin + "" : begin + "->" + end;
  list.add(s);
  return list;
}
