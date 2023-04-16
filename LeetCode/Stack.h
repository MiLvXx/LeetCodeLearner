#pragma once
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <stdlib.h>

typedef int STDataType;
typedef struct Stack 
{
	STDataType* a;
	int top;
	int capacity;
}ST;
// 初始化
void StackInit(ST* ps);
// 销毁
void StackDestory(ST* ps);
// 入栈
void StackPush(ST* ps, STDataType x);
// 出栈
void StackPop(ST* ps);
// 取栈顶的元素
STDataType StackTop(ST* ps);
// 求元素数量
int StackSize(ST* ps);
// 判空
bool StackEmpty(ST* ps);


void StackInit(ST* ps){
    assert(ps);
	ps->a = (STDataType*)malloc(sizeof(STDataType) * 4);
	if (ps->a == NULL) {
		printf("malloc fail\n");
		exit(-1);
	}
	
	ps->capacity = 4;
	ps->top = 0;
}

void StackDestory(ST* ps){
    assert(ps);
	free(ps->a);
	ps->a = NULL;
	ps->top = ps->capacity = 0;
}

void StackPush(ST* ps, STDataType x){
    assert(ps);

	// 扩容
	if (ps->top == ps->capacity) {
		STDataType* tmp = (STDataType*)realloc(ps->a, ps->capacity * 2 * sizeof(STDataType));
		if (tmp == NULL) {
			printf("realloc fail\n");
			exit(-1);
		}
		else {
			ps->a = tmp;
			ps->capacity *= 2;
		}
	}

	ps->a[ps->top] = x;
	ps->top++;
}

void StackPop(ST* ps){
    assert(ps);
	assert(ps->top > 0);
	ps->top--;
}

STDataType StackTop(ST* ps){
    assert(ps);
	assert(ps->top > 0);
	return ps->a[ps->top - 1];
}

int StackSize(ST* ps){
    assert(ps);

	return ps->top;
}

bool StackEmpty(ST* ps){
    assert(ps);

	return ps->top == 0;
}