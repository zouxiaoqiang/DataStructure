package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-27
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int newLen = nums.length;
        int left = 0;
        int right = newLen - 1;
        while (left < newLen) {
            if (nums[left] == val) {
                nums[left--] = nums[right--];
                newLen--;
            }
            left++;
        }
        return newLen;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] a = {1, 1, 1};
        int len = re.removeElement(a, 1);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
