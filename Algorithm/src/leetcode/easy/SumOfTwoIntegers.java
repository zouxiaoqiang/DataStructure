package leetcode.easy;


/**
 * @author xiaoq
 * @date 18-7-12
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            return getSum(sum, carry);
        }
    }

    public static void main(String[] args) {
        SumOfTwoIntegers stt = new SumOfTwoIntegers();
        System.out.println(stt.getSum(2, 3));
    }
}
