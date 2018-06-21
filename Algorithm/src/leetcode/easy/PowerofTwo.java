package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-21
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n > 0) {
            int count = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>= 1;
            }
            return count == 1;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PowerofTwo pt = new PowerofTwo();
        System.out.println(pt.isPowerOfTwo(63));
    }
}
