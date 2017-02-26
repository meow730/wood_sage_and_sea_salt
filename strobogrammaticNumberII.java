public List<String> findStrobogrammatic(int n) {
  return helper(n, n);
}
private List<String> helper(int n, int m) { // len n part of len m result
  if (n == 0) return ArrayList<String>(Arrays.asList("")); 
  if (n == 1) return ArrayList<String>(Arrays.asList("0", "1", "8"));

  List<String> list = helper(n - 2, m);
  List<String> res = new ArrayList<>();
  for (String s : list) {
    if (n != m) res.add("0" + s + "0");
    res.add("1" + s + "1");
    res.add("8" + s + "8");
    res.add("6" + s + "9");
    res.add("9" + s + "6");
  }
  return res;
}
// iterate solu
public List<String> findStrobogrammatic(int n) {
  List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;
  if(n % 2 == 1) r = one;
  for (int i = (n % 2) + 2; i <= n; i += 2) {
    List<String> list = new ArrayList<>();
    for (String s : r) {
      if (i != n) list.add("0" + s + "0");
      list.add("1" + s + "1");
      list.add("8" + s + "8");
      list.add("6" + s + "9");
      list.add("9" + s + "6");
    }
    r = list;
  }
  return r;
}
