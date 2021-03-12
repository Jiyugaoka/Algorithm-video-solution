/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA), lenB = getLength(headB);
        ListNode longer = (lenA >= lenB) ? headA : headB;
        ListNode shorter = (lenA >= lenB) ? headB : headA;
        int k = (lenA >= lenB) ? lenA - lenB : lenB - lenA;
        for (int i = 0; i < k; i++) longer = longer.next;
        while (longer != null && shorter != null && !longer.equals(shorter)) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return (longer == null || shorter == null) ? null : longer;
    }

    private int getLength(ListNode head) {
    //获取链表长度
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}