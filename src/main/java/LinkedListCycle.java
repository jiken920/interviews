/**
 * Created by krudio on 5/25/17.
 */
public class LinkedListCycle {
    public Boolean isCyclic(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
