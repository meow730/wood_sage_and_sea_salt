public List<Interval> merge(List<Interval> intervals) {
  // corner case
  Collections.sort(intervals, new Comparator<Interval>(){
    public int compare(Interval a, Interval b) {
      return a.start - b.start;
    }
  });
  List<Interval> res = new ArrayList<>();
  int start = intervals.get(0).start;
  int end = intervals.get(0).end;
  for (Interval i : intervals) {
    if (i.start <= end) {
      end = Math.max(end, i.end);
    } else {
      res.add(new Interval(start, end));
      start = i.start;
      end = i.end;
    }
  }
  res.add(new Interval(start, end));
  return res;
}
