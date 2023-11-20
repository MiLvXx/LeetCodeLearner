/* MyStackCreate.c -- 225.用队列实现栈 */
#include "Queue.h"
/*
1.入数据，往不为空的队列入
2.出数据，把不为空的队列数据导入空，直到只剩下最后一个

*/
typedef struct
{
    Queue q1;
    Queue q2;
} MyStack;

MyStack *myStackCreate()
{
    MyStack *ps = (MyStack *)malloc(sizeof(MyStack));
    if (ps == NULL)
    {
        printf("malloc fail\n");
        exit(-1);
    }
    QueueInit(&ps->q1);
    QueueInit(&ps->q2);

    return ps;
}

void myStackPush(MyStack *obj, int x)
{
    if (!QueueEmpty(&obj->q1))
    {
        QueuePush(&obj->q1, x);
    }
    else
    {
        QueuePush(&obj->q2, x);
    }
}

int myStackPop(MyStack *obj)
{
    Queue *emptyQ = &obj->q1;
    Queue *nonemptyQ = &obj->q2;
    if (!QueueEmpty(&obj->q1))
    {
        emptyQ = &obj->q2;
        nonemptyQ = &obj->q1;
    }
    // 出数据
    while (QueueSize(nonemptyQ) > 1)
    {
        QueuePush(emptyQ, QueueFront(nonemptyQ));
        QueuePop(nonemptyQ);
    }

    int top = QueueFront(nonemptyQ);
    QueuePop(nonemptyQ);

    return top;
}

int myStackTop(MyStack *obj)
{
    if (!QueueEmpty(&obj->q1))
    {
        return QueueBack(&obj->q1);
    }
    else
    {
        return QueueBack(&obj->q2);
    }
}

bool myStackEmpty(MyStack *obj)
{
    return QueueEmpty(&obj->q1) && QueueEmpty(&obj->q2);
}

void myStackFree(MyStack *obj)
{
    QueueDestory(&obj->q1);
    QueueDestory(&obj->q2);

    free(obj);
}

int main()
{
    MyStack *myStack = myStackCreate();
    myStackPush(myStack, 1);
    myStackPush(myStack, 2);
    printf("%d\n", myStackTop(myStack));
    printf("%d\n", myStackPop(myStack));
    printf("%d\n", myStackEmpty(myStack));
    myStackFree(myStack);
    return 0;
}