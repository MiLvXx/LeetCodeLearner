/* LengthOfLongestSubstring.c -- 3.无重复字符的最长子串 */
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
int lengthOfLongestSubstring(char *s)
{
    /* 以下方案处理较长字符串时间容易超时 */
    /* 方案一 */    
    
    // if(!(*s)){
    //     return 0;
    // }
    // if (strlen(s) == 1)
    // {
    //     return 1;
    // }

    // char *end = s + 1;
    // int count = 1;
    // while (true)
    // {
    //     char *begin = s;
    //     while (true)
    //     {

    //         if (*end != *begin)
    //         {
    //             begin++;
    //             if (end == begin)
    //             {
    //                 break;
    //             }
    //         }
    //         else
    //         {
    //             return lengthOfLongestSubstring(begin + 1) > count ? lengthOfLongestSubstring(begin + 1) : count;
    //         }
    //     }
    //     count++;
    //     end++;
    //     if (end == s + strlen(s))
    //     {
    //         break;
    //     }
    // }

    // return count;

    /* 方案二 */
    
    if (!s || !(*s)) {
        return 0;
    }
    int len = strlen(s);
    int maxLen = 0;
    int start = 0;
    int hash[128] = {0}; // 哈希表记录每个字符最后出现的位置
    for (int i = 0; i < len; i++) {
        if (hash[s[i]] > start) { // 如果该字符已经在哈希表中出现过
            start = hash[s[i]]; // 更新 start
        }
        hash[s[i]] = i + 1; // 更新该字符在哈希表中的位置
        int curLen = i - start + 1; // 计算当前子串长度
        maxLen = curLen > maxLen ? curLen : maxLen; // 更新最长无重复子串长度
    }
    return maxLen;

    
}

int main()
{

    char string[100] = "pwwkew";
    printf("%d\n", lengthOfLongestSubstring(string));
}
