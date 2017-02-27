public int findNthDigit(int n) {
  int len = 1;//位数
  long count = 9;//这位有多少数
  int sum;//总共数多少数
  while (n > len * count) {
    n -= len * count;
    len++;
    count *= 10;
    sum *= 10;
  }
  sum += (n - 1) / len; // find the number location, sum originally has 1
  String s = Integer.toString(sum);
  return Character.getNumericValue(s.charAt((n - 1) % len));
}
