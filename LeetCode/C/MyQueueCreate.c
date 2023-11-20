/* MyStackCreate.c -- 232.用栈实现队列 */
#include "Stack.h"
typedef struct
{
    ST s1; // 用于入队
    ST s2; // 用于出队
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

    StackPush(&obj->s1, x);
}

int myQueuePop(MyQueue *obj)
{

    if (StackEmpty(&obj->s2))
    {
        while (!StackEmpty(&obj->s1))
        {
            StackPush(&obj->s2, StackTop(&obj->s1));
            StackPop(&obj->s1);
        }
    }
    int x = StackTop(&obj->s2);
    StackPop(&obj->s2);
    return x;
}

int myQueuePeek(MyQueue *obj)
{

    if (StackEmpty(&obj->s2))
    {
        while (!StackEmpty(&obj->s1))
        {
            StackPush(&obj->s2, StackTop(&obj->s1));
            StackPop(&obj->s1);
        }
    }
    return StackTop(&obj->s2);
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
    myQueuePush(myQueue, 3);
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