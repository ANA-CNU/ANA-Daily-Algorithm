#include <stdio.h>
#include <stdlib.h>
int n,t;
int k[101];
int s[101];
int dp[101][10001];
int main()
{
    scanf("%d %d",&n,&t);
    for(int i=1; i<=n; i++) scanf("%d %d",&k[i], &s[i]);

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=t; j++) {
            if(j < k[i]) dp[i][j] = dp[i-1][j];
            else {
                dp[i][j] = dp[i-1][j] < dp[i-1][j-k[i]]+s[i] ? dp[i-1][j-k[i]]+s[i] : dp[i-1][j];
            }
        }
    }
    printf("%d",dp[n][t]);
    return 0;
}
