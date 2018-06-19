package leetcode.easy;

import java.util.List;

/**
 * @author xiaoq
 * @date 18-6-19
 */
public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = new ListNode(cur.val);
            tmp.next = res;
            res = tmp;
            cur = cur.next;
        }
        return res;
    }
}
