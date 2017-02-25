public int wordsTyping(String[] sentence, int rows, int cols) {
  int totalCount = 0; // effective char length
  String line = String.join("-", sentence) + "-";
  for (int i = 0; i < rows; i++) {
    totalCount += cols;
    if (line.charAt(totalCount % line.length()) == '-') {// end of word, next line
      totalCount++;
    } else {
      while (totalCount > 0 && line.charAt((totalCount - 1) % line.length()) != '-') {
        totalCount--;
      }
    }
  }
  return totalCount / line.length();
}
