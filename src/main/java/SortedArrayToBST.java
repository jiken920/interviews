/**
 * Created by jiken920 on 4/25/17.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int min, int max) {
        if(min > max) return null;

        int mid = (min + max) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, min, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, max);

        return node;
    }
}
