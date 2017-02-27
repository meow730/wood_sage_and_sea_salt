public int hIndex(int[] citations) {
  // If we don't use the naive way arrays.sort ...
  // kinds of bucket sort
  // 
  // So assume n is the total number of papers, if we have n+1 buckets, number
  // from 0 to n, then for any paper with reference corresponding to the index
  // of the bucket, we increment the count for that bucket.
  int len = citations.length;
  int[] cnt = new int[len + 1]; // 1 ... len
  // H index cannot be greater than the number of citations
  for (int c : citations) {
    if (c > len) {
      cnt[len]++;
    } else {
      cnt[c]++;
    }
  }
  int sum = 0;
  for (int i = len; i >= 0; i--) {
    sum += cnt[i];
    if (sum >= i) {
      return i;
    }
  }
  return 0;
}
