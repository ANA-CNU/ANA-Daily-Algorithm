#include <stdio.h>
#include <stdlib.h>
int dp[1001][1001];
char a[1001];
char b[1001];
int main()
{
    scanf("%s",a);
    scanf("%s",b);

    int a_len = strlen(a);
    int b_len = strlen(b);

    for(int i=1; i<=a_len; i++) {
        for(int j=1; j<=b_len; j++) {
            int max = dp[i-1][j-1];

            if(a[i-1] == b[j-1]) dp[i][j] = max + 1;
            else {
                max = max < dp[i-1][j] ? dp[i-1][j] : max;
                max = max < dp[i][j-1] ? dp[i][j-1] : max;
                dp[i][j] = max;
            }
        }
    }
    printf("%d",dp[a_len][b_len]);
    return 0;
}
