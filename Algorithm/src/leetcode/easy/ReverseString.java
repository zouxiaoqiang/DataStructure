package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-29
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
