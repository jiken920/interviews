/**
 * Created by krudio on 4/20/17.
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode cur = root;
        if(root.val < p.val && root.val < q.val) {
            cur = lowestCommonAncestor(root.right, p, q);
        } else if(root.val > p.val && root.val > q.val) {
            cur = lowestCommonAncestor(root.left, p, q);
        }

        return cur;
    }
}
