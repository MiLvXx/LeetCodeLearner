/* AddTwoNumbers.c -- 2.两数相加 */
#include "list.h"
#include <stdbool.h>
struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
{

    struct ListNode *cur1 = l1;
    struct ListNode *cur2 = l2;
    int res = 0;
    struct ListNode *returnNode = NULL;
    while (true)
    {
        struct ListNode *newNode = (struct ListNode *)malloc(sizeof(struct ListNode));
        int val = (cur1->val + cur2->val + res) % 10;
        res = (cur1->val + cur2->val + res) / 10;
        push(&returnNode, val);

        if (cur1->next == NULL || cur2->next == NULL)
        {
            break;
        }
        cur1 = cur1->next;
        cur2 = cur2->next;
    }
    if (cur1->next)
    {
        cur1 = cur1->next;
        while (true)
        {

            int val = (cur1->val + res) % 10;
            res = (cur1->val + res) / 10;
            push(&returnNode, val);

            if (cur1->next == NULL)
            {
                break;
            }
            cur1 = cur1->next;
        }
    }
    else if (cur2->next)
    {
        cur2 = cur2->next;
        while (true)
        {

            int val = (cur2->val + res) % 10;
            res = (cur2->val + res) / 10;
            push(&returnNode, val);

            if (cur2->next == NULL)
            {
                break;
            }
            cur2 = cur2->next;
        }
    }

    if (res > 0)
    {
        push(&returnNode, res);
    }

    return returnNode;
}

int main()
{
    struct ListNode *L = NULL;

    push(&L, 2);
    push(&L, 4);
    push(&L, 3);

    struct ListNode *L1 = NULL;
    push(&L1, 5);
    push(&L1, 6);
    push(&L1, 4);

    printList(addTwoNumbers(L, L1));

    return 0;
}