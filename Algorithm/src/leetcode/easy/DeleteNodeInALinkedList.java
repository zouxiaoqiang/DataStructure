package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-21
 */
public class DeleteNodeInALinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
