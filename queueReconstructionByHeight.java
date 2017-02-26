public int[][] reconstructQueue(int[][] people) {
  //insert sort
  Arrays.sort(people, new Comparator<int[]>(){
    public int compare(int[] a, int[] b) {
      if (a[0] == b[0]) {
        return a[1] - b[1]; // few -> more
      }
      return b[0] - a[0]; // tall -> short
    }
  });
  ArrayList<int[]> list = new ArrayList<>();
  for (int[] p : people) {
    // insert based on index
    list.add(p[1], p);
  }
  int[][] res = new int[people.length][people[0].length];
  for (int i = 0; i < res.length; i++) {
    res[i] = list.get(i);
  }
  return res;
}
