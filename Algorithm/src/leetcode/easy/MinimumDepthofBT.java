package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-3
 */
public class MinimumDepthofBT {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            if (leftDepth == 0) {
                return rightDepth + 1;
            } else if (rightDepth == 0) {
                return leftDepth + 1;
            } else {
                return Math.min(leftDepth, rightDepth) + 1;
            }
        }
    }
}
