package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoq
 * @date 18-6-17
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        } else {
            Set<Integer> s = new HashSet<>();
            while (n != 1) {
                int t = 0;
                while (n > 0) {
                    t += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = t;
                if (s.contains(n)) {
                    break;
                } else {
                    s.add(n);
                }
            }
            return n == 1;
        }
    }
}
