package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-7
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
            } else if (res == nums[i]) {
                count++;
            } else {
                count --;
            }
        }
        return res;
    }

    public int majorityElement1(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> (31 - i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            bits[i] = bits[i] > nums.length / 2 ? 1 : 0;
            res += bits[i] * (1 << (31 - i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 2, 3, 1, 3, 3};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement1(a));
    }
}
