package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-29
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] != 0) {
            return digits;
        } else {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 0; i < len; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
    }
}
