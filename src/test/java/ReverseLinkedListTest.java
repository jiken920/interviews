import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 3/27/17.
 */
public class ReverseLinkedListTest {
    @Test
    public void reverseList() throws Exception {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLinkedList rev = new ReverseLinkedList();
        ListNode newHead = rev.reverseList(head);

        assertEquals(3, newHead.val);
    }

}