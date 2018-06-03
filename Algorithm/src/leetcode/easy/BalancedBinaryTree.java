package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-3
 */
public class BalancedBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (checkBalanced(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
    private int checkBalanced(TreeNode x) {
        if (x == null) {
            return 0;
        }
        int leftDepth = checkBalanced(x.left);
        int rightDepth = checkBalanced(x.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
