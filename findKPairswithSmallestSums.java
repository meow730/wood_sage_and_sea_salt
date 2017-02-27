public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
  List<int[]> ans = new ArrayList<int[]>();
  PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(
    public int compare(int[] a, int[] b) {
      return a[0] + a[1] - b[0] - b[1];  
    }
  ));
  for (int i = 0; i < nums1.length; i++) {
    pq.add(new int[]{nums1[i], nums2[0], 0});// 3rd => idx in 2
  }
  while (k-- > 0 && !pq.isEmpty() ) {
    int[] cur = pq.poll();
    res.add(new int[]{cur[0], cur[1]});
    if (cur[2] == nums2.length - 1) {
      continue;
    }
    pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
  }
  return res;
}
