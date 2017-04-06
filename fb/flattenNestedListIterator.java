public class NestedIterator implements Iterator<Integer> {
  // isInteger, getInteger, getList
  Stack<NestedInteger> stack;
  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack<NestedInteger>();
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));  
    }
  }

  public Integer next() {
    return stack.pop().getInteger();
  }

  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger cur = stack.peek();
      if (cur.isInteger()) {
        return true;
      }
      // list
      stack.pop()
      for (int i = cur.size() - 1; i >=0; i--) {
        stack.push(cur.getList().get(i));
      }
    }
    return false;
  }
}
// Or store iterator
NestedInteger nextInt;
Stack<Iterator<NestedInteger>> stack;

public NestedIterator(List<NestedInteger> nestedList) {
  stack = new Stack<Iterator<NestedInteger>>();
  stack.push(nestedList.iterator());
}

public Integer next() {
  return nextInt.getInteger();
}

public boolean hasNext() {
  while (!stack.isEmpty()) {
    if (!stack.peek().hasNext()) {
      stack.pop();
    } else {
      // Note, because it's iterator, next() will move offset every time
      NestedInteger next = stack.peek().next();
      if (next.isInteger) {
        nextInt = next;
        return true;
      }
      stack.push(next.getList().iterator());
    }
  }
  return false;
}
