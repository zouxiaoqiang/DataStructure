package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaoq
 * @date 18-6-2
 */
public class BTLevelOrderTraversalII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            ArrayList<Integer> levelRes = new ArrayList<>();
            int curLevCnt = 1;
            int nextLevCnt = 0;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                curLevCnt--;
                levelRes.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                    nextLevCnt++;
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    nextLevCnt++;
                }
                if (curLevCnt == 0) {
                    curLevCnt = nextLevCnt;
                    nextLevCnt = 0;
                    res.add(0, levelRes);
                    levelRes = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
