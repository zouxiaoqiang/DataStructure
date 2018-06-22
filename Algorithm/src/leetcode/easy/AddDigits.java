package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-22
 */
public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public int addDigits1(int num) {
        while (num / 10 > 0) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits1(38));
    }
}
