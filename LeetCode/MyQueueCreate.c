/* MyStackCreate.c -- 232.用栈实现队列 */
#include "Stack.h"
typedef struct
{
    ST s1;
    ST s2;
} MyQueue;

MyQueue *myQueueCreate()
{
    MyQueue *myQueue = (MyQueue *)malloc(sizeof(MyQueue));

    if (myQueue == NULL)
    {
        printf("malloc fail\n");
        exit(-1);
    }
    StackInit(&myQueue->s1);
    StackInit(&myQueue->s2);

    return myQueue;
}

void myQueuePush(MyQueue *obj, int x)
{
    ST *emptyStack = &obj->s1;
    ST *nonemptyStack = &obj->s2;

    if (!StackEmpty(&obj->s1))
    {
        emptyStack = &obj->s2;
        nonemptyStack = &obj->s1;
    }
    else
    {
        StackPush(nonemptyStack, x);
    }
}

int myQueuePop(MyQueue *obj)
{
    ST *emptyStack = &obj->s1;
    ST *nonemptyStack = &obj->s2;
    int top;
    if (!StackEmpty(&obj->s1))
    {
        emptyStack = &obj->s2;
        nonemptyStack = &obj->s1;
    }
    else
    {
        while (StackSize(nonemptyStack) > 1)
        {
            StackPush(emptyStack, StackTop(nonemptyStack));
            StackPop(nonemptyStack);
        }
        top = StackTop(nonemptyStack);

        StackPop(nonemptyStack);
        while (StackSize(emptyStack) > 0)
        {
            StackPush(nonemptyStack, StackTop(emptyStack));
            StackPop(emptyStack);
        }
    }
    return top;
}

int myQueuePeek(MyQueue *obj)
{
    ST *emptyStack = &obj->s1;
    ST *nonemptyStack = &obj->s2;
    int top;
    if (!StackEmpty(&obj->s1))
    {
        emptyStack = &obj->s2;
        nonemptyStack = &obj->s1;
    }
    else
    {
        while (StackSize(nonemptyStack) > 1)
        {
            StackPush(emptyStack, StackTop(nonemptyStack));
            StackPop(nonemptyStack);
        }
        top = StackTop(nonemptyStack);
        while (StackSize(emptyStack) > 0)
        {
            StackPush(nonemptyStack, StackTop(emptyStack));
            StackPop(emptyStack);
        }
    }
    return top;
}

bool myQueueEmpty(MyQueue *obj)
{
    return StackEmpty(&obj->s1) && StackEmpty(&obj->s2);
}

void myQueueFree(MyQueue *obj)
{
    StackDestory(&obj->s1);
    StackDestory(&obj->s2);

    free(obj);
}

int main()
{
    MyQueue *myQueue = myQueueCreate();
    myQueuePush(myQueue, 1);

    printf("%d\n", myQueuePop(myQueue));
    printf("%d\n", myQueueEmpty(myQueue));
    return 0;
}
/**
 * Your MyQueue struct will be instantiated and called as such:
 * MyQueue* obj = myQueueCreate();
 * myQueuePush(obj, x);

 * int param_2 = myQueuePop(obj);

 * int param_3 = myQueuePeek(obj);

 * bool param_4 = myQueueEmpty(obj);

 * myQueueFree(obj);
*/