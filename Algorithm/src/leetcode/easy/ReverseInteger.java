package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-25
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean flag = true;
        long res = 0, tmp = x;
        if (tmp < 0) {
            flag = false;
            tmp *= -1;
        }
        while (tmp != 0) {
            res = tmp % 10 + res * 10;
            tmp /= 10;
        }
        res = flag ? res : -res;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            res = 0;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        ReverseInteger rt = new ReverseInteger();
        System.out.println(rt.reverse(-123));
    }
}
