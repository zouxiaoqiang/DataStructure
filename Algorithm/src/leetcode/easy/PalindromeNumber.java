package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-25
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            long res = 0, tmp = x;
            while (x != 0) {
                res = res * 10 + x % 10;
                x /= 10;
            }
            if (res == tmp) {
                return true;
            } else {
                return false;
            }
        }
    }
}
