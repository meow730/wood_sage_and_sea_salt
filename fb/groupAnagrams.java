public List<List<String>> groupAnagrams(String[] strs) {
  List<List<String>> res = new ArrayList<>();
  HashMap<String, List<String>> map = new HashMap<>();
  Arrays.sort(strs);
  for (String s : strs) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    String key = String.valueOf(chars);
    if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
    map.get(key).add(s);
  }
  return new ArrayList<List<String>>(map.values());
}
// 一个数分解成质数相乘的结果唯一
int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
List<List<String>> res = new ArrayList<>();
HashMap<Integer, Integer> map = new HashMap<>();
for (String s : strs) {
   int key = 1;
   for (char c : s.toCharArray()) {
     key *= prime[c - 'a'];
   }
   List<String> t;
   if (map.containsKey(key)) {
     t = res.get(map.get(key));
   } else {
     t = new ArrayList<>();
     res.add(t);
     map.put(key, res.size() - 1);
  }
  t.add(s);
}
return res;
