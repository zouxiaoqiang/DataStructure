package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-26
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if (strs.length > 0) {
            int len = Integer.MAX_VALUE;
            String ex = null;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < len) {
                    ex = strs[i];
                    len = ex.length();
                }
            }
            for (int index = 0; index < len; index++) {
                char ch = ex.charAt(index);
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].charAt(index) != ch) {
                        index = len;
                        break;
                    } else if (i == strs.length - 1) {
                        res.append(ex.charAt(index));
                    }
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"aca", "cba"};
        System.out.println(lcp.longestCommonPrefix(strs));
    }
}
