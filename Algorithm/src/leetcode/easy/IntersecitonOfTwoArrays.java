package leetcode.easy;

import java.util.Arrays;

/**
 * @author xiaoq
 * @date 18-6-29
 */
public class IntersecitonOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] res = new int[len1 < len2 ? len1 : len2];
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || res[k - 1] != nums1[i]) {
                    res[k++] = nums1[i];
                }
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

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {1};
        IntersecitonOfTwoArrays ita = new IntersecitonOfTwoArrays();
        int[] c = ita.intersection(a, b);
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
