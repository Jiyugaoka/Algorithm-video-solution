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
    ListNode* reverseList1(ListNode* head) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* cur = head, *next = nullptr;
        while (cur != nullptr && cur->next != nullptr) {
            next = cur->next;
            cur->next = next->next;
            next->next = dummy->next;
            dummy->next = next;
        }
        return dummy->next;
    }
    ListNode* reverseList2(ListNode* head) {
        /** 
            pre代表cur左侧反转的结果
            cur代表当前要处理的节点，cur及以后的节点仍与输入完全相同。
        */
        ListNode* pre = nullptr, *cur = head, *next = nullptr;
        while (cur != nullptr) {
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode* reverseList3(ListNode* head) {
        if (head == nullptr || head->next == nullptr) return head;
        ListNode* temp = reverseList(head->next);
        // 此刻head 和 head->next之间是双向链接
        head->next->next = head;
        // 断开这个双向链接
        head->next = nullptr;
        return temp;
    }
};