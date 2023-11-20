/* MergeTwoLists.c -- 21.合并两个有序链表 */
#include "list.h"
struct ListNode *mergeTwoLists(struct ListNode *list1, struct ListNode *list2);
int main()
{
    struct ListNode *list1 = NULL;
    push(&list1, 1);
    push(&list1, 2);
    push(&list1, 3);
    push(&list1, 4);
    printList(list1);

    struct ListNode *list2 = NULL;
    push(&list2, 1);
    push(&list2, 3);
    push(&list2, 5);
    push(&list2, 7);
    printList(list2);

    struct ListNode *mergeList = mergeTwoLists(list1, list2);
    printList(mergeList);
}
struct ListNode *mergeTwoLists(struct ListNode *list1, struct ListNode *list2)
{
    if (list1 == NULL)
    {
        return list2;
    }

    if (list2 == NULL)
    {
        return list1;
    }

    struct ListNode *head = NULL, *tail = NULL;
    // 哨兵位
    head = tail = (struct ListNode*)malloc(sizeof(struct ListNode));
    
    // if (list1->val < list2->val)
    // {
    //     head = tail = list1;
    //     list1 = list1->next;
    // }
    // else
    // {
    //     head = tail = list2;
    //     list2 = list2->next;
    // }

    while (list1 != NULL && list2 != NULL)
    {
        if (list1->val < list2->val)
        {

            // 尾插
            tail->next = list1;

            list1 = list1->next;
        }
        else
        {

            tail->next = list2;

            list2 = list2->next;
        }

        tail = tail->next;
    }

    if (list1)
    {
        tail->next = list1;
    }
    if (list2)
    {
        tail->next = list2;
    }

    struct ListNode* first = head->next;
    free(head);
    return first;

    // return head;
}