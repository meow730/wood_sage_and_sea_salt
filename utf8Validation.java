public boolean validUtf8(int[] data) {
  // null, len 0 => false
  for (int i = 0; i < data.length; i++) {
    int bytesCnt = 0;
    if (data[i] > 255) { // 11111111
      return false;
    }
    // 128 => 10000000
    // 224 => 11100000; 192 => 11000000
    // 240 => 11110000; 248 => 11111000
    if (data[i] < 128) { 
      bytesCnt = 1;
    } else if ((data[i] & 224) == 192) {
      bytesCnt = 2;
    } else if ((data[i] & 240) == 224) {
      bytesCnt = 3;
    } else if ((data[i] & 248) == 240) {
      bytesCnt = 4;
    }
    for (int j = 1, j < bytesCnt; j++) {
      if (i + j > data.length) return false;
      if ((data[i + j] & 192) != 128) return false;
    }
    i = i + bytesCnt - 1;// till j
  }
  return true;
}
