/**
 * Created by jiken920 on 3/29/17.
 */
public class FindInBST {
    private static int isPresent(TreeNode root, int val){
        if(root == null) {
            return 0;
        }
        if(root.val == val) {
            return 1;
        }

        if(val < root.val) {
            return isPresent(root.left, val);
        }
        else {
            return isPresent(root.right, val);
        }
    }
}
