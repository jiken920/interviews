/**
 * Created by krudio on 5/18/17.
 */
public class BSTNextSuccessor {
    public TreeNode findNextSuccessor(TreeNode root, int target) {
        TreeNode succ = null;
        while(root != null) {
            if(root.val > target) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}
