public class LongestConsecutive {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if(root == null) { return 0; }
        longestConsecutive(root, 0, root.val);
        return this.max;
    }

    public void longestConsecutive(TreeNode root, int target, int cur) {
        if(root == null) { return; }
        if(root.val == target) {
            ++cur;
        } else {
            cur = 1;
        }

        max = Math.max(cur, max);
        longestConsecutive(root.left, root.val + 1, cur);
        longestConsecutive(root.right, root.val + 1, cur);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


