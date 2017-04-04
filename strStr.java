public int strStr(String haystack, String needle) {
  if (haystack.length() < needle.length()) return -1;
  if (needle.length == 0) return 0;
  for (int i = 0; i <= haystack.length() - needle.length(); i++) {
    if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
  }
  return -1;
}
// Another
for (int i = 0; i <= haystack.length() - needle.length(); i++) {
  for (int j = 0; j <= needle.length(); j++) {
    if (j == needle.length()) return i;
    if (haystack.charAt(i + j) != needle.charAt(j)) break;
  }
}
return -1;
