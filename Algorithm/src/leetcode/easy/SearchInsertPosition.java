package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-28
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        SearchInsertPosition sip = new SearchInsertPosition();
        System.out.println(sip.searchInsert(a, 11));
    }
}
