public class RandomizedSet {

  HashMap<Integer, Integer> map; // value, index in arraylist
  ArrayList<Integer> list; // value
  Random rand;
  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  public boolean insert(int val) {
    if (!map.containsKey(val)) return false;
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) return false;
    int idx = map.get(val);
    if (idx < list.size() - 1) {
      // kinda swap with last one
      int tail = list.get(list.size() - 1);
      list.set(idx, tail);
      map.put(tail, idx);
    }
    list.remove(list.size() - 1);
    return true;
  }

  public int getRandom() {
    if (list.isEmpty()) return -1;
    int r = rand.nextInt(list.size());
    return list.get(r);
  }
}
// notes: if have duplicate can use HashMap<Integer, List<Integer>>
