package leetcode.easy;

import java.util.ArrayList;

/**
 * @author xiaoq
 * @date 18-6-3
 */
public class PathSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int newSum = sum - root.val;
        if (root.left == null && root.right == null) {
            return sum == root.val;
        } else if (root.left == null) {
            return hasPathSum(root.right, newSum);
        } else if (root.right == null) {
            return hasPathSum(root.left, newSum);
        } else {
            return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
        }
    }

}
