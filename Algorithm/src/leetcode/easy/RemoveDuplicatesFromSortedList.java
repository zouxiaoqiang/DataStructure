package leetcode.easy;

/**
 * @author xiaoq
 * @date 18-5-31
 */
public class RemoveDuplicatesFromSortedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (true) {
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            left.next = right;
            left = right;
            if (right != null) {
                right = right.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = rdfsl.deleteDuplicates(head);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

        System.out.println();
    }
}
