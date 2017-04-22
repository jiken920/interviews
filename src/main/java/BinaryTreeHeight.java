/**
 * Created by krudio on 3/29/17.
 */
public class BinaryTreeHeight {
    public static int height(TreeNode root) {
        if(root == null) { return -1; }

        int lefth = height(root.left);
        int righth = height(root.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }
}
