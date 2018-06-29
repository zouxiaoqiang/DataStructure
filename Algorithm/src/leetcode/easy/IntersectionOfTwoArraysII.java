package leetcode.easy;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @author xiaoq
 * @date 18-6-29
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[len1 < len2 ? len1 : len2];
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                res[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }
}
