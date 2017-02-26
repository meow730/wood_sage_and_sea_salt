public String reverseVowels(String s) {
  if (s == null || s.length() < 2) return s;
  int head = 0;
  int tail = s.length() -1;
  HashSet<Character> vowels = new HashSet<>();
  vowels.add('a');
  vowels.add('e');
  vowels.add('i');
  vowels.add('o');
  vowels.add('u');
  char[] strs = s.toCharArray();
  while (head < tail) {
    while (head < tail && !vowels.contains(Character.toLowerCase(strs[head]))) {
      head++;
    }
    while (head < tail && !vowels.contains(Character.toLowerCase(strs[tail]))) {
      tail--;
    }
    char tmp = strs[head];
    strs[head] = strs[tail];
    strs[tail] = tmp;
    head++;
    tail--;
  }
  return String.valueOf(strs);
}
