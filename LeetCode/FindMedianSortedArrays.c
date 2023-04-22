/* FindMedianSortedArrays -- 4.寻找两个正序数组的中位数 */
/* 本题要求时间复杂度为 O(log(m+n)) */
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define min(a, b) (((a) < (b)) ? (a) : (b));
/*
// 暴力解法,时间复杂度 O(m+n)
double findMedianSortedArrays(int *nums1, int nums1Size, int *nums2, int nums2Size)
{
    int size = (nums1Size + nums2Size) / 2 + 1;
    int *newArray = (int *)malloc(sizeof(int) * (size + 1));
    int *cur = newArray;

    int *flag1 = nums1;
    int *flag2 = nums2;
    while (cur < newArray + size)
    {
        if (flag1 == NULL)
        {
            while (cur != newArray + size)
            {
                *cur = *flag2;
                ++flag2;
                ++cur;
            }
            break;
        }
        if (flag2 == NULL)
        {
            while (cur != newArray + size)
            {
                *cur = *flag1;
                ++flag1;
                ++cur;
            }
            break;
        }
        if (flag1 == nums1 + nums1Size - 1 && *flag1 < *flag2)
        {
            *cur = *flag1;
            ++cur;
            while (cur != newArray + size)
            {
                *cur = *flag2;
                ++flag2;
                ++cur;
            }
            break;
        }
        if (flag2 == nums2 + nums2Size - 1 && *flag2 < *flag1)
        {
            *cur = *flag2;
            ++cur;
            while (cur != newArray + size)
            {
                *cur = *flag1;
                ++flag1;
                ++cur;
            }
            break;
        }

        if ((*flag1) < (*flag2))
        {
            *cur = *flag1;
            if (flag1 != nums1 + nums1Size - 1)
                ++flag1;
            ++cur;
        }
        else
        {
            *cur = *flag2;
            if (flag2 != nums2 + nums2Size - 1)
                ++flag2;
            ++cur;
        }
    }
    double result;
    if ((nums1Size + nums2Size) % 2 == 0)
    {
        result = (double)(*(newArray + size - 1) + *(newArray + (size - 2))) / 2;
        free(newArray);
        return result;
    }
    else
    {
        result = (double)(*(newArray + size - 1));
        free(newArray);
        return result;
    }
}
*/

int getKthElement(int *nums1, int nums1Size, int *nums2, int nums2Size, int k)
{
    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */

    int m = nums1Size;
    int n = nums2Size;
    int index1 = 0, index2 = 0;

    while (true)
    {
        // 边界情况
        if (index1 == m)
        {
            return nums2[index2 + k - 1];
        }
        if (index2 == n)
        {
            return nums1[index1 + k - 1];
        }
        if (k == 1)
        {
            return min(nums1[index1], nums2[index2]);
        }

        // 正常情况
        int newIndex1 = min(index1 + k / 2 - 1, m - 1);
        int newIndex2 = min(index2 + k / 2 - 1, n - 1);
        int pivot1 = nums1[newIndex1];
        int pivot2 = nums2[newIndex2];
        if (pivot1 <= pivot2)
        {
            k -= newIndex1 - index1 + 1;
            index1 = newIndex1 + 1;
        }
        else
        {
            k -= newIndex2 - index2 + 1;
            index2 = newIndex2 + 1;
        }
    }
}

double findMedianSortedArrays(int *nums1, int nums1Size, int *nums2, int num2Size)
{
    int totalLength = nums1Size + num2Size;
    if (totalLength % 2 == 1)
    {
        return getKthElement(nums1, nums1Size, nums2, num2Size, (totalLength + 1) / 2);
    }
    else
    {
        return (getKthElement(nums1, nums1Size, nums2, num2Size, totalLength / 2) + getKthElement(nums1, nums1Size, nums2, num2Size, totalLength / 2 + 1)) / 2.0;
    }
}

int main()
{

    int array1[2] = {1, 3};
    int array2[5] = {2, 4, 8, 9, 9};

    double returnValue = findMedianSortedArrays(array1, 2, array2, 5);
    printf("%f", returnValue);
    return 0;
}