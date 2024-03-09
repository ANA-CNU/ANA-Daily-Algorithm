#include <stdio.h>

int main()
{
    int testCase = 0;
    scanf("%d", &testCase);

    for (int i = 0; i < testCase; ++i)
    {
        int a = 0, b = 0;
        scanf("%d %d", &a, &b);

        printf("%d\n", a+b);
    }

    return 0;
}