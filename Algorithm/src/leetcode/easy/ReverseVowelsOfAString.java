package leetcode.easy;

import java.util.HashSet;

/**
 * @author xiaoq
 * @date 18-6-29
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<Character>() {
            {
                add('a'); add('A');
                add('e'); add('E');
                add('i'); add('I');
                add('o'); add('O');
                add('u'); add('U');
            }
        };
        int left = 0;
        int right = s.length() - 1;
        char[] res = s.toCharArray();
        while (left < right) {
            char c1 = res[left];
            char c2 = res[right];
            if (vowels.contains(c1) && vowels.contains(c2)) {
                res[left++] = c2;
                res[right--] = c1;
            } else if (vowels.contains(c1)) {
                right--;
            } else if (vowels.contains(c2)) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return String.valueOf(res);
    }
}
