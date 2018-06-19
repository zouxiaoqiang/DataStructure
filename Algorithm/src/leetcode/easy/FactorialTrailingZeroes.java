package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-12
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
        System.out.println(ftz.trailingZeroes(30));
    }
}
