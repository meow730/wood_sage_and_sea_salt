public ListNode reverseList(ListNode head) {
  ListNode newHead = null;
  while (head != null) {
    ListNode next = head.next;
    head.next = newHead;
    newHead = head;
    head = next;
  }
  return newHead;
}
// Recur
public ListNode reverseList(ListNode head) {
  return helper(head, null);
}

private helper(ListNode head, ListNode newHead){
  if (head == null) return newHead;
  ListNode next = head.next;
  head.next = newHead;
  return helper(next, head);
}

