package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-2
 */
public class ConvertSAtoBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }
    }
    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            TreeNode cur = new TreeNode(nums[mid]);
            cur.left = sortedArrayToBST(nums, lo, mid - 1);
            cur.right = sortedArrayToBST(nums, mid + 1, hi);
            return cur;
        } else {
            return null;
        }
    }
}
