#include <stdio.h>
#include <stdlib.h>
char a[1001];
char b[1001];
int dp[1001][1001];
void f(int x, int y){
    if(dp[x][y] == 0) return;
    if(a[y-1] == b[x-1]) {
        f(x-1, y-1);
        printf("%c",a[y-1]);
    }
    else {
        if(dp[x][y] == dp[x-1][y]) f(x-1, y);
        else f(x, y-1);
    }
}
int main()
{
    scanf("%s",a);
    scanf("%s",b);

    int a_len = strlen(a);
    int b_len = strlen(b);

    for(int i=1; i<=a_len; i++) {
        for(int j=1; j<=b_len; j++) {
            int max = 0;
            if(a[i-1] == b[j-1]) {
                max = dp[j-1][i-1] + 1;
            }
            else {
                max = dp[j-1][i-1];
                max = max < dp[j-1][i] ? dp[j-1][i] : max;
                max = max < dp[j][i-1] ? dp[j][i-1] : max;
            }
            dp[j][i] = max;
        }
    }
    printf("%d\n",dp[b_len][a_len]);
    if(dp[b_len][a_len] != 0) f(b_len, a_len);
    return 0;
}
