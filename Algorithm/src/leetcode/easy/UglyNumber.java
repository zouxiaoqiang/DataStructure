package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-22
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        } else {
            int[] primes = {2, 3, 5};
            boolean divisible = false;
            while (num != 1) {
                for (int i : primes) {
                    if (num % i == 0) {
                        divisible = true;
                        num /= i;
                    }
                }
                if (!divisible) {
                    return false;
                } else {
                    divisible = false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(8));
    }
}
