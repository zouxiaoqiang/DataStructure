package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-28
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
            int n = 31;
            for (int i = 0; i < n; i++) {
                if ((num >> i & 1) == 1) {
                    return i % 2 == 0 && num == 1 << i;
                }
            }
            return false;
    }

    public static void main(String[] args) {
        PowerOfFour pf = new PowerOfFour();
        System.out.println(pf.isPowerOfFour(-4));
    }
}
