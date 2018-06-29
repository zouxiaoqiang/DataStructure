package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-29
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
