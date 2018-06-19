package leetcode.easy;

import java.util.HashSet;

/**
 * @author xiaoq
 * @date 18-6-19
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> dup = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dup.contains(nums[i])) {
                return true;
            } else {
                dup.add(nums[i]);
            }
        }
        return false;
    }
}
