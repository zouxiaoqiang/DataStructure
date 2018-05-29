package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-27
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        int newLen = nums.length;
        while (right < newLen) {
            while (right < newLen && nums[left] == nums[right]) {
                right++;
            }
            int h = right - left - 1;
            if (h > 0) {
                int cur = left + 1;
                while (right < newLen) {
                    nums[cur] = nums[cur + h];
                    cur++;
                    right++;
                }
                newLen -= h;
            }
            left++;
            right = left + 1;
        }
        return newLen;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 2, 3, 3, 3, 5};
        RemoveDuplicates rd = new RemoveDuplicates();
        int len = rd.removeDuplicates(a);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
