import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/23/17.
 */
public class PlusOneLinkedListTest {
    @Test
    public void plusOne() throws Exception {
        PlusOneLinkedList plusOne = new PlusOneLinkedList();
        ListNode head = new ListNode(9);
        ListNode next = new ListNode(9);
        head.next = next;
        head = plusOne.plusOne(head);
        assertEquals(1, head.val);
        assertEquals(0, head.next.val);
        assertEquals(0, head.next.next.val);

        head = new ListNode(9);
        next = new ListNode(0);
        head.next = next;
        head = plusOne.plusOne(head);
        assertEquals(9, head.val);
        assertEquals(1, head.next.val);
    }

}