package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoq
 * @date 18-6-4
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        int index = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (index <= numRows) {
            List<Integer> rowRes = new ArrayList<>();
            if (index == 1) {
                rowRes.add(1);
            } else if (index == 2) {
                rowRes.add(1);
                rowRes.add(1);
            } else {
                List<Integer> pre = res.get(res.size() - 1);
                rowRes.add(1);
                for (int i = 0; i < pre.size() - 1; i++) {
                    rowRes.add(pre.get(i) + pre.get(i + 1));
                }
                rowRes.add(1);
            }
            res.add(rowRes);
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> res = pt.generate(6);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> l = res.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }
    }
}
