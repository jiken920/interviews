import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by krudio on 5/23/17.
 *
 * Write a function to iteratively determine the total number of "full nodes" in a binary tree.
 * A full node contains left and right child nodes. If there are no full nodes, return 0.
 */
public class NumberOfFullNodes {
    public int numberOfFullNodes(TreeNode root) {
        int result = 0;
        if(root == null) return result;

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left != null && cur.right != null) result++;
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }

        return result;
    }
}
