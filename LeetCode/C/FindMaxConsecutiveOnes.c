/* FindMaxConsecutiveOnes.c -- 485.最大连续1的个数 */
#include<stdio.h>
#include<stdbool.h>

int findMaxConsecutiveOnes(int* nums, int numsSize){
    int* cur = nums;
    int count = 0;
    int maxCount = 0;
    for(int i = 0; i < numsSize; i++){
        if(*cur == 1){
            count++;
        }else{
            if(count > maxCount){
                maxCount = count;
            }
            count = 0;
        }
        ++cur;
    }
    return maxCount > count ? maxCount : count;
}

int main(){
    int nums[6] = {1,1,0,1,1,1};
    printf("%d\n", findMaxConsecutiveOnes(nums, sizeof(nums)/sizeof(int)));
}