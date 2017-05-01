import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by jiken920 on 3/29/17.
 */
public class BinaryTreeInversion {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) { return null; }

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public TreeNode invertTreeIter(TreeNode root) {
        if(root == null) { return null; }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if(cur.left != null) {
                queue.offer(cur.left);
            }

            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return root;
    }

}
