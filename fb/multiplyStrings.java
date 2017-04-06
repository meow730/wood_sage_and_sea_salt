public String multiply(String num1, String num2) {
  int[] pos = new int[num1.length() + num2.length()];

  for (int i = num1.length() - 1; i >= 0; i--) {
    for (int j = num2.length() - 1; j >= 0; j--) {
      int mu = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      int cur = i + j + 1;
      int next = i + j;
      int sum = mu + pos[cur];//!

      pos[cur] = sum % 10;
      pos[next] += sum / 10;
    }
  }

  StringBuilder sb = new StringBuilder();
  for (int p : pos) {
    if (sb.length() == 0 && p == 0) continue;
    sb.append(p);
  }
  return sb.length() ==  0 ? "0": sb.toString();
}
