public String decodeString(String s) {
  StringBuilder sb = new StringBuilder();
  Stack<Integer> cnt = new Stack<>();
  Stack<String> result = new Stack<>();
  int i = 0;
  result.push("");
  while (i < s.length()) {
    char c = s.charAt(i);
    if (Character.isDigit(c)) {
      int begin  = i;
      while (Character.isDigit(s.charAt(i + 1))) {
        i++;
      }
      cnt.push(Integer.parseInt(s.substring(begin, i + 1)));
    } else if (c == '[') {
      result.push("");
    } else if (c == ']') {
      int times = cnt.pop();
      StringBuilder tmp = new StringBuilder();
      String curStr = result.pop();
      for (int k = 0; k < times; k++) {
        tmp.append(curStr);
      }
      result.push(result.pop() + sb.toString());
    } else {
      result.push(result.pop() + c);
    }
    i++;
  }
  return result.pop();
}
