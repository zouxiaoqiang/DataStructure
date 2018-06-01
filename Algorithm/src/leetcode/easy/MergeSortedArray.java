package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-31
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                m++;
                for (int k = m - 1; k > i; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i++] = nums2[j++];
            } else {
                i++;
            }
        }
        while (j < n) {
            nums1[m++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 8, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] b = {0, 2, 4, 5, 6, 9, 10};
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(a, 5, b, 7);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
