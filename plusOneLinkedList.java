public ListNode plusOne(ListNode head) {
  ListNode dummy = new ListNode(0);
  dummy.next = head;
  ListNode tail = dummy;
  ListNode begin = dummy;// the begin node that might be affected be carrier

  // go to tail
  while (tail.next != null) {
    tail = tail.next;
    if (tail.val != 9) {
      begin = tail; // the last node val < 9
    }
  }

  if (tail.val < 9) {
    tail.val++;
  } else {
    begin.val++;
    // all nodes after begin should be 0
    begin = begin.next;
    while (begin != null) {
      begin.val = 0;
      begin = begin.next;
    }
  }

  return dummy.val == 0 ? dummy.next : dummy;
}
