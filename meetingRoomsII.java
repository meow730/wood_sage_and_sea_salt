public int minMeetingRooms(Interval[] intervals) {
  Arrays.sort(intervals, new Comparator<Interval>(
    public int compare(Interval a, Interval b) {
      return a.start - b.start;
    }      
  )); // early start => late start
  int cnt = 0;
  PriorityQueue<Integer> pq = new PriorityQueue<>();// track meeting ends from early to late
  for (Interval i : intervals) {
    if (pq.isEmpty()) {
      pq.add(i.end);
      cnt++;
      continue;
    } 
    if (pq.peek() <= i.start) {
      pq.poll(); // share same room
      pq.add(i.end);
    } else {
      pq.add(i.end);
      cnt++;
    }
  }
  return cnt;
}
