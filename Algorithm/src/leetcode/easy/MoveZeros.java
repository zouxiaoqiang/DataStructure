package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-23
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums != null && nums.length != 0) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] == 0) {
                    for (int i = l; i < r; i++) {
                        nums[i] = nums[i + 1];
                    }
                    nums[r--] = 0;
                } else {
                    l++;
                }
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] a = {0, 1, 0, 3, 12, 0};
        mz.moveZeroes(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
