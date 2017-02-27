public int[] findPermutation(String s) {
  int[] arr = new int[s.length() + 1];
  for (int i = 0; i < arr.length; i++) {
    arr[i] = i + 1;
  }
  for (int i = 0; i < s.length(); i++) {
    if (s.charAt(i) == 'D') {
      int start = i;
      while (i < s.length() && s.charAr(i) == 'D') {
        i++;
      }
      reverse(arr, start, i);
    }
  }
  return arr;
}
private void reverse(int[] arr, int i, int j) {
  while (i < j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
    i++;
    j--;
  }
}
