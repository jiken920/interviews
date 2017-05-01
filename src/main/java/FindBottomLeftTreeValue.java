import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by jiken920 on 4/16/17.
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:

   2
  / \
 1   3

 Output: 1

 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            root = nodes.poll();

            // Traverse the tree using BFS from right to left
            if(root.right != null) {
                nodes.offer(root.right);
            }

            if(root.left != null) {
                nodes.offer(root.left);
            }
        }

        // This should be the last value we see, which will be the bottom-left-most value
        return root.val;
    }
}
