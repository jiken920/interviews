import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiken920 on 3/29/17.
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

    public static boolean isBSTInorder(TreeNode root) {
        if(root == null) {
            return true;
        }

        List<TreeNode> nodes = new ArrayList<>();
        traverseTree(root, nodes);

        if(nodes.size() == 1) {
            return true;
        }

        int i = 0, j = 1;
        while(j < nodes.size() - 1) {
            if(nodes.get(i).val > nodes.get(j).val) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static void traverseTree(TreeNode root, List<TreeNode> nodes) {
        if(root == null) {
            return;
        }

        traverseTree(root.left, nodes);
        nodes.add(root);
        traverseTree(root.right, nodes);
    }
}
