package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-28
 */
public class MaximumSubarray {
    /**
     * Kadane_algorithm, O(n)
     */
    public int maxSubArray(int[] nums) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            max_ending_here += nums[i];
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    /**
     * Divide and conquer, O(nlogn)
     * In an array,
     * there are three cases for the largest subarray:
     * 1.to the left of the midpoint
     * 2.to the right of the midpoint
     * 3.past the midpoint
     */
    public int maxSubArray1(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    private int merge(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        if (lo == hi - 1) {
            return Math.max(nums[lo] + nums[hi], Math.max(nums[lo], nums[hi]));
        }
        int mid = lo + (hi - lo) / 2;
        int lmax = merge(nums, lo, mid - 1);
        int rmax = merge(nums, mid + 1, hi);
        int mmax = nums[mid];
        int tmp = mmax;
        for (int i = mid - 1; i >= lo; i--) {
            tmp += nums[i];
            if (tmp > mmax) {
                mmax = tmp;
            }
        }
        tmp = mmax;
        for (int i = mid + 1; i <= hi; i++) {
            tmp += nums[i];
            if (tmp > mmax) {
                mmax = tmp;
            }
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }

}
