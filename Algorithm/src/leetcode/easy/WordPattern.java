package leetcode.easy;

import java.util.HashMap;

/**
 * @author xiaoq
 * @date 18-6-24
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        } else {
            HashMap<Character, String> m = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (m.containsKey(c)) {
                    if (!m.get(c).equals(arr[i])) {
                        return false;
                    }
                } else if (m.containsValue(arr[i])) {
                    return false;
                } else {
                    m.put(c, arr[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(
                wp.wordPattern("abba", "dog cat cat dog")
        );
    }
}
