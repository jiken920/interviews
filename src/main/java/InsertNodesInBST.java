/**
 * Created by krudio on 5/23/17.
 *
 * Implement a method to insert a node into a Binary Search Tree.
 * Return the root of the modified tree.
 */
public class InsertNodesInBST {
    public TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            return new TreeNode(data);
        }

        if(data < root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }
}
