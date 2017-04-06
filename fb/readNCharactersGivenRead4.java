public int read(char[] buf, int n) {
  // read is actually write ... = =
  boolean eof = false;
  int total = 0;
  char[] tmp = new char[4];
  while (!eof && total < n) {
    int count = read4(tmp);
    // Is last write EOF?
    eof = count < 4;
    // Maybe next write will be less than 4?
    count = Math.min(count, n - total);
    // use tmp to write to buffer
    for (int i = 0; i < count; i++) {
      buf[total++] = tmp[i];
    }
  }
  return total;
}
