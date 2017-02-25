public int[] plusOne(int[] digits) {
  // a simple code version instead of bruce force
  for (int i = digits.length - 1; i >= 0; i--) {
    if (digits[i] < 9) {
        digits[i]++;
        return digits;
    }
    digits[i] = 0;
  }
  // not return yet, still have carrier
  int[] newDigits = new int[digits.length + 1];
  newDigits[0] = 1;
  return newDigits;
}
