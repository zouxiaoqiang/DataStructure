package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-5
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!isAlphanumeric(c1)) {
                left++;
            } else if (!isAlphanumeric(c2)) {
                right--;
            } else if (c1 == c2 ||
                    (c1 >= 'A' && c2 >= 'A' && Math.abs(c1 - c2) == 32)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= '0' && c <= '9') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
