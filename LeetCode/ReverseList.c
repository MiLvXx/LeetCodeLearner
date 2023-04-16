/* ReverseList.c--206.反转链表 */
#include "list.h"


// 反转
struct ListNode *reverseList(struct ListNode *head);

int main()
{
    struct ListNode *test = NULL;
    push(&test, 1);
    push(&test, 2);
    push(&test, 3);
    printList(test);

    printList(reverseList(test));
    return 0;
}

struct ListNode *reverseList(struct ListNode *head)
{

    /* 方法一 */
    // 初始条件
    if (head == NULL)
    {
        return NULL;
    }
    struct ListNode *n1 = NULL, *n2 = head, *n3 = n2->next;
    // 结束条件
    while (n2)
    {
        n2->next = n1;

        n1 = n2;
        n2 = n3;
        if (n3)
            n3 = n3->next;
    }

    return n1;

    /*方法二*/
    // struct ListNode* cur = head;
    // struct ListNode* newHead = NULL;
    // while(cur){
    //     struct ListNode* next = cur->next;

    //     // 头插
    //     cur->next = newHead;
    //     newHead = cur;
    //     cur = next;
    // }

    // return newHead;
}
