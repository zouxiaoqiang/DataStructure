package leetcode.easy;

import ch1.Stack;

/**
 * @author xiaoq
 * @date 18-5-29
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        Stack<Character> stack = new Stack<>();
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        char c = a.charAt(0);
        int carry = 0;
        int i1, i2, sum;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                i1 = 0;
            } else {
                i1 = a.charAt(index1--) - '0';
            }
            if (index2 < 0) {
                i2 = 0;
            } else {
                i2 = b.charAt(index2--) - '0';
            }
            sum = i1 + i2 + carry;
            if (sum > 1) {
                stack.push((char) (sum - 2 + '0'));
                carry = 1;
            } else {
                stack.push((char) (sum + '0'));
                carry = 0;
            }
        }
        if (carry == 1) {
            stack.push((char) (carry + '0'));
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String a = "1011";
        String b = "1111";
        System.out.println(ab.addBinary(a, b));
    }
}
