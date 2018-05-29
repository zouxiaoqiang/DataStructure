package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-27
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        int len1 = haystack.length() - needle.length() + 1;
        int len2 = needle.length();
        for (int i = 0; i < len1; i++) {
            int left = 0;
            for (int j = 0; j < len2; j++) {
                if (haystack.charAt(i + left) != needle.charAt(j)) {
                    break;
                } else if (j == needle.length() - 1) {
                    return i;
                }
                left++;
            }
        }
        return -1;
    }
}
