import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krudio on 4/22/17.
 */
public class BinaryTreeHeightTest {
    @Test
    public void height() throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);

        int height = BinaryTreeHeight.height(root);
        assertEquals(3, height);
    }

}