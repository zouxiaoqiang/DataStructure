package leetcode.easy;


/**
 * @author xiaoq
 * @date 18-6-20
 */
public class InvertBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) {
                root.left = invertTree(root.left);
            }
            if (root.right != null) {
                root.right = invertTree(root.right);
            }
            return root;
        }
    }

    private void inOrder(TreeNode t) {
        if (t != null) {
            inOrder(t.left);
            System.out.print(t.val + " ");
            inOrder(t.right);
        }
    }

    public static void main(String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode tree = ibt.new TreeNode(4);
        tree.left = ibt.new TreeNode(2);
        tree.right = ibt.new TreeNode(7);
        tree.left.left = ibt.new TreeNode(1);
        tree.left.right = ibt.new TreeNode(3);
        tree.right.left = ibt.new TreeNode(6);
        tree.right.right = ibt.new TreeNode(9);
        ibt.inOrder(tree);
        System.out.println();
        ibt.invertTree(tree);
        ibt.inOrder(tree);
        System.out.println();
    }

}
