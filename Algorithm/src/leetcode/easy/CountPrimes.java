package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaoq
 * @date 18-6-18
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int limit = (int)Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            for (int j = i * i; j < n; j += i) {
                if (primes[j]) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(20));
    }
}
