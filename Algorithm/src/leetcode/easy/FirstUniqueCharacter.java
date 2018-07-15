package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-7-15
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int[] bits = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bits[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (bits[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
