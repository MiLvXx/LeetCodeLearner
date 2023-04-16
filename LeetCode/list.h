#pragma once
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>


// 单链表
struct ListNode
{
    int val;
    struct ListNode *next;
};

// 尾插
void push(struct ListNode **pphead, int e)
{

    struct ListNode *newList = (struct ListNode *)malloc(sizeof(struct ListNode));
    assert(newList);

    newList->val = e;
    newList->next = NULL;

    if (*pphead == NULL)
    {
        *pphead = newList;
    }
    else
    {
        struct ListNode *tail = *pphead;
        while (tail->next != NULL)
        {
            tail = tail->next;
        }
        tail->next = newList;
    }
}

// 遍历
void printList(struct ListNode *head)
{
    struct ListNode *cur = head;
    while (cur != NULL)
    {
        printf("%d->", cur->val);
        cur = cur->next;
    }
    printf("NULL\n");
}