/* DetectCycle.c -- 142.环形链表Ⅱ */
#include"list.h"
struct ListNode *detectCycle(struct ListNode *head) {
    struct ListNode* slow = head, * fast = head;
    while(fast && fast->next)
    {
        slow = slow->next;
        fast = fast->next->next;

        // 一个指针从相遇点开始走，一个指针从head开始走
        // 它们在入口点相遇
        if(slow == fast){
            struct ListNode* meet = slow;
            while(head != meet){
                head = head->next;
                meet = meet->next;
            }

            return meet;
        }
    }
    return NULL;
}