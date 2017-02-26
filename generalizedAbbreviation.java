public List<String> generateAbbreviations(String word) {
//  The idea is: for every character, we can keep it or abbreviate it. To keep it, we add it to the current solution and carry on backtracking. To abbreviate it, we omit it in the current solution, but increment the count, which indicates how many characters have we abbreviated.
  List<String> res = new ArrayList<>();  
  backtrack(res, word, 0, new StringBuilder(), 0);
  return res;
}
private void backtrack(List<String> r, String word, int i, StringBuilder sb, int cnt){
  if(i == word.length()) {
    if (cnt != 0) sb.append(cnt);
    r.add(sb.toString());
  } else {
    int len = sb.length();
    backtrack(r, word, i + 1, sb, cnt + 1); // abbr
    sb.setLength(len);
    backtrack(r, word, i + 1, sb.append(cnt > 0 ? cnt : "").append(word.charAt(i)), 0); // keep char
    sb.setLength(len);
  }
}
