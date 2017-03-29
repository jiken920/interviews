/**
 * Created by krudio on 3/29/17.
 */
public class IsBST {
    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.val >= min && root.val <= max &&
                isBST(root.left, min, root.val) && isBST(root.right, root.val, max)) {
            return true;
        } else {
            return false;
        }
    }
}
