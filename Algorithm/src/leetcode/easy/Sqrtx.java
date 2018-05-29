package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-29
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = (int) mid + 1;
            } else if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                return (int) mid;
            }
        }
        return right;
    }
}
