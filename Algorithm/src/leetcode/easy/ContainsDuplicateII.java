package leetcode.easy;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author xiaoq
 * @date 18-6-19
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                Integer val = m.get(nums[i]);
                if (i - val <= k) {
                    return true;
                } else {
                    m.replace(nums[i], val, i);
                }
            } else {
                m.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII cd = new ContainsDuplicateII();
        int[] a = {1, 0, 1, 1};
        System.out.println(cd.containsNearbyDuplicate(a, 1));
    }
}
