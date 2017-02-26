class PeekingIterator implements Iterator<Integer> {

  private Iterator<Integer> it;
  private Integer next;

  public PeekingIterator(Iterator<Integer> iterator) {
    it = iterator;
    if (it.hasNext()) {
      next = it.next();
    }
  }

  public Integer peek() {
    return next;
  }

  public Integer next() {
    int toReturn = next;
    if (it.hasNext()) {
      next = it.next()
    } else {
      next = null;
    }
    return toReturn;
  }

  public boolean hasNext() {
    return next != null;       
  }
}
// Or use a queue, have every integer offered when initializes
