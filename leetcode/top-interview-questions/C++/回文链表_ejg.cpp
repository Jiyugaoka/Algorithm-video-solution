/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    /**
    反转链表II:
    https://leetcode-cn.com/problems/reverse-linked-list-ii/
    */
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* dummy = new ListNode(-1);
        ListNode* pre = dummy;
        pre->next = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre->next;
        }
        ListNode* cur = pre->next;
        ListNode* next = nullptr;
        for (int i = 0; i < right - left; i++) {
            next = cur->next;
            cur->next = next->next;
            next->next = pre->next;
            pre->next = next;
        }
        return dummy->next;
    }

    int getLength(ListNode* head) {
    //获取链表长度
        int count = 0;
        while(head != nullptr){
            count++;
            head = head->next;
        }
        return count;
    }

    bool isPalindrome(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return true;
        int len = getLength(head);
        int half = (len % 2 == 0) ? len / 2 + 1: len / 2 + 2;
        head = reverseBetween(head, half, len);
        ListNode *slow = head, *fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }
        if (len % 2 == 1) {
            slow = slow->next;
        }
        ListNode *pre = head;
        bool res = true;
        while (slow != nullptr) {
            if (pre->val != slow->val) {
                res = false;
                break;
            }
            pre = pre->next;
            slow = slow->next;
        }
        // head = reverseBetween(head, half, len);
        return res;
    }

    
};