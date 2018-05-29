package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoq
 * @date 18-5-25
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        int size = nums.length;
        int i;
        for (i = 0; i < size; i++) {
            int elem = nums[i];
            if (m.containsKey(elem)) {
                res[0] = m.get(elem);
                res[1] = i;
                return res;
            } else {
                m.put(target - elem, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] r = twoSum(a, 9);
        for (int i : r) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
