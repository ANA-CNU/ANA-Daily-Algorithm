#include <stdio.h>
#include <stdlib.h>
int coin[21];
int dp[10001];
int n;
int main()
{
    int t,m;
    for(scanf("%d",&t);t--;){
        scanf("%d", &n);
        for(int i=1; i<=n; i++) {
            scanf("%d",&coin[i]);
        }
        scanf("%d",&m);
        for(int i=1; i<=m; i++) dp[i] = 0;
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(coin[i] <= j) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }
        printf("%d\n",dp[m]);
    }
    return 0;
}
