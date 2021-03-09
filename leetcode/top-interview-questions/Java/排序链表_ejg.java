/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList1(ListNode head) {
        return sortList(head, null);
    }

    // 左闭右开
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return head;
        if (head.next == tail) {
            // 断开两个链表
            head.next = null;
            return head;
        }
        // 寻找终点，一分为二，分别调用递归。
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return dummyHead.next;
    }

    private int getLength(ListNode head){
    //获取链表长度
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    private ListNode cut(ListNode head, int step) {
        // 断链操作 返回第二部分链表头
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode end = cur.next;
        cur.next = null; // 切断连接
        return end;
    }

    public ListNode sortList(ListNode head) {
        int length = getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
       
        for (int step = 1; step < length; step *= 2) { 
            // 每次变换步长后都将pre指针和cur指针都初始化在链表头, 这样才是每次操作1块，2块，4块...
            ListNode pre = dummy; 
            ListNode cur = dummy.next;
            while (cur!=null) {
                ListNode h1 = cur; 
                ListNode h2 = cut(h1,step);  // 这一步执行完毕h1指向的链表的长度才是step
                cur = cut(h2,step); // 同理，这一步执行完毕h1指向的链表的长度才是step， 此外还将cur向后挪动了2倍step的长度。
                ListNode temp = merge(h1,h2); // 合并两个有序链表
                pre.next = temp; // 将前面的部分与排序好的部分连接
                while(pre.next!=null) {
                    pre = pre.next; // 把pre指针移动到排序好的部分的末尾
                }
            }
        }
        return dummy.next;
    }
}