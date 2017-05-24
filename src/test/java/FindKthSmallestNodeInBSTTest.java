import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 5/24/17.
 */
public class FindKthSmallestNodeInBSTTest {
    @Test
    public void findKthSmallest() throws Exception {
        FindKthSmallestNodeInBST main = new FindKthSmallestNodeInBST();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(30);
        TreeNode result = main.findKthSmallest(root, 2);

        assertEquals(10, result.val);
    }

}