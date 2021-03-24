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
    ListNode* oddEvenList(ListNode* head) {
        ListNode* odd = new ListNode(-1);
        ListNode* even = new ListNode(-1);
        int count = 1;
        ListNode *ptr = head, *ptr1 = odd, *ptr2 = even;
        while (ptr != nullptr) {
            ListNode* nextNode = ptr->next;
            // 一个一个的摘下来
            ptr->next = nullptr;
            if (count & 1) {
                ptr1->next = ptr;
                ptr1 = ptr1->next;
            } else {
                ptr2->next = ptr;
                ptr2 = ptr2->next;
            }
            count++;
            ptr = nextNode;
        }
        ptr1->next = even->next;
        return odd->next;
    }
};