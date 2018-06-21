package leetcode.easy;


/**
 * @author xiaoq
 * @date 18-6-21
 */
public class PalindromeLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        } else {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            /**
             * reverse the second half list
             * @parm pre: the first node in the second half of list
             * */
            ListNode pre = slow.next;
            ListNode cur = pre.next;
            pre.next = null;
            while (cur != null) {
                ListNode nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
            ListNode l1 = head;
            ListNode l2 = pre;
            while (l2 != null) {
                if (l1.val != l2.val) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
        }
    }
}
