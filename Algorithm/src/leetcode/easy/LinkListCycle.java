package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-6-6
 */
public class LinkListCycle {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        /**
         * if link list has a cycle,
         * slower and faster will must meet.
         */
        ListNode slower = head, faster = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;
    }
}
