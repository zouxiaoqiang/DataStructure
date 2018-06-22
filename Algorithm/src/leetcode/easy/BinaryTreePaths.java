package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoq
 * @date 18-6-22
 */
public class BinaryTreePaths {
    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String s = "";
        binaryTreePath(root, s);
        return list;
    }

    private void binaryTreePath(TreeNode x, String s) {
        if (x != null) {
            if (x.left == null && x.right == null) {
                s += x.val;
                list.add(s);
            } else {
                s += x.val + "->";
                binaryTreePath(x.left, s);
                binaryTreePath(x.right, s);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        List<String> l = btp.binaryTreePaths(tree);
        for (String s : l) {
            System.out.println(s);
        }
    }

}
