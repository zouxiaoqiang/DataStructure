package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-2
 */
public class MaximumDepthofBT {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);
            return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
        }
    }
}
