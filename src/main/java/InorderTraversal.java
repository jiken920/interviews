import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jiken920 on 3/29/17.
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        traverse(root, results);
        return results;
    }

    public void traverse(TreeNode root, List<Integer> results) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stk = new Stack<>();

        // push the left nodes first
        TreeNode cur = root;
        while(cur != null) {
            stk.push(cur);
            cur = cur.left;
        }

        while(!stk.isEmpty()) {
            cur = stk.pop(); // pop the value and print it
            results.add(cur.val);

            if(cur.right != null) { // now push the right nodes
                stk.push(cur.right);
                cur = cur.right;

                while(cur.left != null) { // finally, push all the left nodes in the right tree
                    stk.push(cur.left);
                    cur = cur.left;
                }
            }
        }
    }
}
