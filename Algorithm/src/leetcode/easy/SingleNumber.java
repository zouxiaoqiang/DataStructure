package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-5
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] a = {4, 2, 1, 2, 1};
        System.out.println(sn.singleNumber(a));
    }
}
