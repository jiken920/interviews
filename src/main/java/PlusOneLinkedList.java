/**
 * Created by krudio on 3/23/17.
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        // Traverse j to the end of the list
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit. If there are no 9's at the end, then i == j

        i.val++; // Increment i
        i = i.next;
        while (i != null) { // Zero out everything after i (which should be 9's)
            i.val = 0;
            i = i.next;
        }

        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
