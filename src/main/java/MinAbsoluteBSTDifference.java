import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiken920 on 3/23/17.
 */
public class MinAbsoluteBSTDifference {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preOrder(root, results);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < results.size() - 1; i++) {
            int diff = Math.abs(results.get(i) - results.get(i + 1));
            min = Math.min(diff, min);
        }

        return min;
    }

    public void preOrder(TreeNode root, List<Integer> results) {
        if(root == null) {
            return;
        }

        preOrder(root.left, results);
        results.add(root.val);
        preOrder(root.right, results);
    }
}
