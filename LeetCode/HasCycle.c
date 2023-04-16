/* HasCycle.c -- 141.环形链表 */
#include<stdbool.h>
#include"list.h"
bool hasCycle(struct ListNode* head){
    // 快慢指针
    struct ListNode* slow = head, * fast = head;
    while (fast && fast->next)
    {
        slow = slow->next;
        fast = fast->next->next;

        if(slow == fast){
            return true;
        }
    }

    return false;
}