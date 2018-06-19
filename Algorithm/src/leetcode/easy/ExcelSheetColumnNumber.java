package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-7
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int index = s.length() - 1;
        int cnt = 0;
        int res = 0;
        while (index >= 0) {
            int num = s.charAt(index--) - 'A' + 1;
            res += num * pow(26, cnt++);
        }
        return res;
    }
    private int pow(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber escn = new ExcelSheetColumnNumber();
        System.out.println(escn.titleToNumber("AB"));
    }
}
