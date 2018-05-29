package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-28
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            char ch = s.charAt(i--);
            if (ch == ' ' && len != 0) {
                break;
            }
            if (ch != ' ') {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLastWord llw = new LengthOfLastWord();
        System.out.println(llw.lengthOfLastWord("  a  baf "));
    }
}
