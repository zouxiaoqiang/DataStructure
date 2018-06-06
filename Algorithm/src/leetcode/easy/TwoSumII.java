package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-6
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int tmp = target - numbers[i];
            int j = binarySearch(numbers, i + 1, len - 1, tmp);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    private int binarySearch(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
