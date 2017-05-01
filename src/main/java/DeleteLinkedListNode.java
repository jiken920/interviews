/**
 * Created by jiken920 on 3/27/17.
 */
public class DeleteLinkedListNode {
    public void deleteNode(ListNode node) {
        if(node == null) { return; }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
