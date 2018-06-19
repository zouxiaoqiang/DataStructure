package leetcode.easy;

import java.util.Stack;

/**
 * @author xiaoq
 * @date 18-6-7
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        Stack<Character> s = new Stack<>();
        while (n != 0) {
            int r = n % 26;
            n /= 26;
            if (r == 0) {
                s.push('Z');
                n--;
            } else {
                s.push((char)('A' + r - 1));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append(s.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
        System.out.println(esct.convertToTitle(703));
    }
}
