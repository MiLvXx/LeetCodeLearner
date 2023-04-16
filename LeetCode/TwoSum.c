/* TwoSum.c -- 1.两数之和*/
#include <stdio.h>
#include <stdlib.h>
int *twoSum(int *nums, int numsSize, int target, int *returnSize);

int main()
{
    int nums[] = {3, 2, 7};
    int target = 9;
    int returnSize = 0;
    printf("%d\n", twoSum(nums, sizeof(nums) / sizeof(nums[0]), target, &returnSize)[0]);
    printf("%d\n", twoSum(nums, sizeof(nums) / sizeof(nums[0]), target, &returnSize)[1]);
}

int *twoSum(int *nums, int numsSize, int target, int *returnSize)
{

    for (int i = 0; i < numsSize; i++)
    {
        for (int j = i + 1; j < numsSize; j++)
        {
            if (nums[i] + nums[j] == target)
            {
                int *ret = malloc(sizeof(int) * 2);
                ret[0] = i, ret[1] = j;
                *returnSize = 2; // 返回长度
                return ret;
            }
        }
    }
    // 如果未找到
    *returnSize = 0;
    return NULL;
}