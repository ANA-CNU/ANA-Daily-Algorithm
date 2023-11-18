#include <stdio.h>
#include <stdlib.h>
int n,m;
int dp[1001][1001];
char arr[1001][1001];
int max = 0;
int main()
{
    scanf("%d %d ",&n,&m);
    for(int i=0; i<n; i++) gets(arr[i]);

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            if(arr[i-1][j-1] == '0') continue;

            int x = dp[i-1][j-1];
            x = x > dp[i-1][j] ? dp[i-1][j] : x;
            x = x > dp[i][j-1] ? dp[i][j-1] : x;

            dp[i][j] = x + 1;
            max = max < dp[i][j] ? dp[i][j] : max;
        }
    }
    printf("%d",max * max);
    return 0;
}
