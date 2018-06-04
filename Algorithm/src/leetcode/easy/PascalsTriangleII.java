package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoq
 * @date 18-6-4
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0);
        }
        for (int i = 0; i <= rowIndex; i++) {
            res.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangleII ptii = new PascalsTriangleII();
        List<Integer> list = ptii.getRow(6);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
