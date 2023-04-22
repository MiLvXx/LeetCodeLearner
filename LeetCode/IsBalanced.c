/* IsBalanced.c -- 110.平衡二叉树 */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
struct TreeNode{
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

int maxDepth(struct TreeNode *root)
{
    if(root == NULL) return 0;
    int leftDepth = maxDepth(root->left);
    int rightDepth = maxDepth(root->right);

    return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
}
bool isBalanced(struct TreeNode* root){
    if(root == NULL) return true;
    int leftDepth = maxDepth(root->left);
    int rightDepth = maxDepth(root->right);
   
    return abs(leftDepth - rightDepth) < 2
        && isBalanced(root->left)
        && isBalanced(root->right);
}

int main(){

    struct TreeNode* A = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    A->left = NULL;
    A->right = NULL;
    A->val = 3;

    struct TreeNode* B = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    B->left = NULL;
    B->right = NULL;
    B->val = 9;

    struct TreeNode* C = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    C->left = NULL;
    C->right = NULL;
    C->val = 20;

    struct TreeNode* D = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    D->left = NULL;
    D->right = NULL;
    D->val = 15;

    struct TreeNode* E = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    E->left = NULL;
    E->right = NULL;
    E->val = 7;

    struct TreeNode* F = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    F->left = NULL;
    F->right = NULL;
    F->val = 7;

    A->left = B;
    A->right = C;
    C->left = D;
    C->right = E;
    //E->right = F;

    int flag = isBalanced(A);
    if(flag){
        printf("这棵树是高度平衡二叉树");
    }else{
        printf("这棵树不是高度平衡二叉树");
    }
    return 0;
}