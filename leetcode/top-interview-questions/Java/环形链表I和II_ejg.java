/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 此处是环形链表I的代码实现
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) break;
        }
        return (fast == null || fast.next == null) ? false : true;
    }

/* *
 * 此处是环形链表II的代码实现
 */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        ListNode ptr = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                while (!slow.equals(ptr)) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                break;
            }
        } 
        return (fast == null || fast.next == null) ? null : ptr;
    }
}