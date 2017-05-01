import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiken920 on 3/23/17.
 */
public class MinAbsoluteBSTDifferenceTest {
    @Test
    public void getMinimumDifference() throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        MinAbsoluteBSTDifference main = new MinAbsoluteBSTDifference();
        int min = main.getMinimumDifference(root);

        assertEquals(1, min);
    }

}