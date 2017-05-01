import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jiken920 on 3/24/17.
 */
public class LinkedListRandomNode {
    private ListNode head;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int size = 0, index = 0;
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            size++;
        }

        int randomIdx = ThreadLocalRandom.current().nextInt(0, size + 1);
        cur = head;
        while(index <= size) {
            if(index == randomIdx) {
                return cur.val;
            } else {
                cur = cur.next;
                index++;
            }
        }

        return index;
    }
}
