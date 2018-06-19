package leetcode.easy;

import java.util.HashMap;

/**
 * @author xiaoq
 * @date 18-6-18
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> isomorphic = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            if (isomorphic.containsKey(c1)) {
                if (!isomorphic.get(c1).equals(c2)) {
                    return false;
                }
            } else {
                if (isomorphic.containsValue(c2)) {
                    return false;
                } else {
                    isomorphic.put(c1, c2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println(is.isIsomorphic("egg", "add"));
    }
}
