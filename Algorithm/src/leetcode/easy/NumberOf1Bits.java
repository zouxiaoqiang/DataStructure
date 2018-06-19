package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-13
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++, n >>= 1) {
            if ((n & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
