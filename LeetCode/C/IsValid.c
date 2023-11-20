/* IsValid.c -- 20.有效的括号 */
#include "Stack.h"

bool isValid(char *s);

int main()
{
    char *s = "([)";
    printf("%d\n", isValid(s));
    return 0;
}
bool isValid(char *s)
{
    ST st;
    StackInit(&st);
    while (*s != '\0')
    {
        switch (*s)
        {
        case '{':
        case '[':
        case '(':
        {
            StackPush(&st, *s);
            ++s;
            break;
        }

        case '}':
        case ']':
        case ')':
        {
            if (StackEmpty(&st))
            {
                StackDestory(&st);
                return false;
            }
            char top = StackTop(&st);
            StackPop(&st);
            // 不匹配
            if ((*s == '}' && top != '{') || (*s == ']' && top != '[') || (*s == ')' && top != '('))
            {
                StackDestory(&st);
                return false;
            }
            else
            {
                ++s;
            }
            break;
        }
        default:
            break;
        }
    }

    bool ret = StackEmpty(&st);
    StackDestory(&st);
    return ret;
}