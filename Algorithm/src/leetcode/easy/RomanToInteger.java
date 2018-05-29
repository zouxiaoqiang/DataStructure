package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoq
 * @date 18-5-26
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> transform = new HashMap<>(7);
        transform.put('I', 1);
        transform.put('V', 5);
        transform.put('X', 10);
        transform.put('L', 50);
        transform.put('C', 100);
        transform.put('D', 500);
        transform.put('M', 1000);
        int len = s.length() - 1;
        int index = 0;
        int res = 0;
        while (index < len) {
            int cur = transform.get(s.charAt(index));
            int next = transform.get(s.charAt(index + 1));
            if (cur < next) {
                res += next - cur;
                index++;
            } else {
                res += cur;
            }
            index++;
        }
        if (index == len) {
            res += transform.get(s.charAt(index));
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("III"));
    }
}
