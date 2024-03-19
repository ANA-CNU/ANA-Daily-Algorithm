#include <stdio.h>
#include <stdlib.h>
int n,k,a[1001],b[1001];
int dp[1001][10001];
int max;
int main()
{
    scanf("%d %d",&n,&k);
    for(int i=1; i<=k; i++) {
        scanf("%d %d",&a[i], &b[i]);
    }
    for(int i=1; i<=k; i++) {
        for(int j=1; j<=n; j++) {
            if(j < b[i]) dp[i][j] = dp[i-1][j];
            else {
                if(dp[i-1][j] < dp[i-1][j-b[i]] + a[i]) {
                    dp[i][j] = dp[i-1][j-b[i]] + a[i];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
    }
    for(int i=1; i<=n; i++) {
        max = max < dp[k][i] ? dp[k][i] : max;
    }
    printf("%d",max);
    return 0;
}
