/**
 * Created by jiken920 on 3/27/17.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) { return null; }
        if(head.next == null) { return head; }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    public ListNode reverseListIter(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
