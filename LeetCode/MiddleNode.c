/* MiddleNode.c -- 876.链表的中间结点 */
#include "list.h"
struct ListNode *middleNode(struct ListNode *head);

int main()
{
    struct ListNode *test = NULL;
    push(&test, 1);
    push(&test, 2);
    push(&test, 3);
    push(&test, 4);
    push(&test, 6);

    /*
    快速创建测试链表，适用于接口型OJ题
    struct ListNode *test;
    struct ListNode* n1 = (struct ListNode*)malloc(sizeof(struct ListNode));
    n1->val = 1;
    struct ListNode* n2 = (struct ListNode*)malloc(sizeof(struct ListNode));
    n2->val = 2;
    struct ListNode* n3 = (struct ListNode*)malloc(sizeof(struct ListNode));
    n3->val = 3;
    test = n1;
    n1->next = n2;
    n2->next = n3;
    n3->next = NULL;
    */

    printList(test);

    printList(middleNode(test));
    return 0;
}

struct ListNode *middleNode(struct ListNode *head)
{   
    // 快慢指针
    struct ListNode *slow = head, *fast = head;
    while (fast && fast->next)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}