/* PreorderTraversal.c -- 144.二叉树的前序遍历 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
};

int TreeSize(struct TreeNode* root){
    return root == NULL ? 0 : TreeSize(root->left) + 
    TreeSize(root->right) + 1;

}

void _prevOrder(struct TreeNode* root, int* a, int* i){
    if(root == NULL)
        return;

    a[*i] = root->val;
    ++(*i);

    _prevOrder(root->left, a, i);
    _prevOrder(root->right, a, i);
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){
    int size = TreeSize(root);
    int* returnArray = (int*)malloc(sizeof(size * sizeof(int)));
    int i = 0;
    _prevOrder(root, returnArray, &i);

    *returnSize = size;
    return returnArray;
   
}

/* 测试 */
int main(){
    struct TreeNode* A = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    assert(A);
    A->val = 1;
    A->left = NULL;
    A->right = NULL;

    struct TreeNode* B = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    assert(B);
    B->val = 2;
    B->left = NULL;
    B->right = NULL;

    struct TreeNode* C = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    assert(C);
    C->val = 3;
    C->left = NULL;
    C->right = NULL;

    A->right = B;
    B->left = C;

    int returnSize = 0;
    int* s = preorderTraversal(A, &returnSize);
   
    for(int i = 0; i < 3; i++){
        printf("%d\n", s[i]);
    }
    printf("%d\n", returnSize);
    return 0;
}