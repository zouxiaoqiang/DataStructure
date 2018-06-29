package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-23
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res ^= i;
        }
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] a = {0, 3, 1};
        System.out.println(mn.missingNumber(a));
    }
}
