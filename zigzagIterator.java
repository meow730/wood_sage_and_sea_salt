public class ZigzagIterator {
  // can use a boolean field to track 2
  // use a int value to track k
  // Or have a queue to track those iterators
  Queue<Iterator> queue;
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    queue = new LinkedList<>();
    if (!v1.isEmpty()) {
      queue.add(v1.iterator());
    }
    if (!v2.isEmpty()) {
      queue.add(v2.iterator());
    }
  }
  
  public int next() {
    Iterator it = queue.poll();
    int next = it.next();
    if (it.hasNext()) {
      queue.offer(it);
    }
    return next;
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }
}
