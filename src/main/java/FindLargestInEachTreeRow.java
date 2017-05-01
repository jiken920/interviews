import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by jiken920 on 4/16/17.
 */
public class FindLargestInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);

        while(!nodes.isEmpty()) {
            int rowMax = Integer.MIN_VALUE;
            int queueSize = nodes.size(); // Take a snapshot of the current queue size.

            // Iterate through the current set of items in the queue. This should represent a single level in the queue
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = nodes.poll();
                rowMax = Math.max(rowMax, cur.val);
                if(cur.left != null) nodes.add(cur.left);
                if(cur.right != null) nodes.add(cur.right);
            }

            // We're at the end of the level. Add the max value to our list of results
            result.add(rowMax);

        }

        return result;
    }
}
