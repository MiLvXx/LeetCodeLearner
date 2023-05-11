/* MinMoves.c -- 453.最小操作次数使数组元素相等 */
#include<stdio.h>
#include<stdbool.h>
/*
int finMaxIndex(int* nums, int numsSize){
    int max = nums[0];
    int index = 0;
    for(int i = 1; i < numsSize; i++){
        if(nums[i] > max){
            max = nums[i];
            index = i;
        }
    }
    return index;
    
}
bool isAllEqual(int* nums, int numsSize){
    bool flag = true;
    int begin = *nums;
    for(int i = 1; i < numsSize; i++){
        if(nums[i] != begin){
            flag = false;
        }
    }
    return flag;
}
int minMoves(int* nums, int numsSize){
    int count = 0;
    while(isAllEqual(nums, numsSize) != true){
        int maxIndex = finMaxIndex(nums, numsSize);
        for(int i = 0; i < numsSize; i++){
            if(i != maxIndex){
                nums[i]++;
            } 
        }
        count++;
    }
    return count;
    
}
*/
int minMoves(int* nums, int numsSize){
    int sum = 0;
    int minMum = nums[0];
    for(int i = 0; i < numsSize; i++){
        if (minMum > nums[i]) minMum = nums[i];
    }
    for(int j = 0; j < numsSize; j++){
        sum += (nums[j] - minMum);
    }
    return sum;
    
}
int main(){
    int nums[] = {1,999999};
    int numsSize = sizeof(nums)/sizeof(int);
    printf("%d\n", minMoves(nums, numsSize));
    return 0;
}