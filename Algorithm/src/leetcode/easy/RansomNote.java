package leetcode.easy;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-7-14
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        } else if (magazine == null || magazine.length() == 0) {
            return false;
        } else {
            char[] ra = ransomNote.toCharArray();
            char[] ma = magazine.toCharArray();
            Arrays.sort(ra);
            Arrays.sort(ma);
            int i = 0, j = 0;
            while (j < ma.length && i < ra.length && ra[i] >= ma[j]) {
                char c = ra[i];
                int k = j;
                for (; k < ma.length && ma[k] != c; k++) {
                }
                j = k + 1;
                i++;
            }
            return i == ra.length && j <= ma.length;
        }
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aa", "aab"));
    }
}
