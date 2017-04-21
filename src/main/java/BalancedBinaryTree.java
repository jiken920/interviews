/**
 * Created by krudio on 4/21/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(height(root.left) - height(root.right)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return 1 + Math.max(lHeight, rHeight);
    }
}
