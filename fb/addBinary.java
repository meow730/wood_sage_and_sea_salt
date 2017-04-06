public String addBinary(String a, String b) {
  int i = a.length() - 1; j = b.length() - 1;
  StringBuilder sb = new StringBuilder();
  int carry = 0;
  while (i >= 0 || j >= 0) {
    int sum = carry;
    if (i >= 0) sum += a.charAt(i) - '0';
    if (j >= 0) sum += a.charAt(j) - '0';
    sb.append(sum % 2);
    carry = sum / 2;
  }
  return sb.reverser().toString();
}
