/**
 * Created by krudio on 5/24/17.
 */
public class FindKthSmallestNodeInBST {
    private TreeNode val;
    private int count;

    public TreeNode findKthSmallest(TreeNode root, int k) {
        count = k;
        val = root;
        helper(root);
        return val;
    }

    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.left);
        count--;
        if(count == 0) {
            val = root;
            return;
        }
        helper(root.right);
    }
}
