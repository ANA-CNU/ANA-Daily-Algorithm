#include <stdio.h>
#include <stdlib.h>
int memory[101];
int cost[101];
int dp[101][10001];
int isOk;
int sum;
int main()
{
    int n,m;
    scanf("%d %d",&n,&m);
    for(int i=1; i<=n; i++) scanf("%d",&memory[i]);
    for(int i=1; i<=n; i++) scanf("%d",&cost[i]);

    for(int i=1; i<=n; i++) {
        for(int j=0; j<=10000; j++) {
            if(cost[i] > j) dp[i][j] = dp[i-1][j];
            else {
                dp[i][j] = dp[i-1][j] < dp[i-1][j-cost[i]] + memory[i] ?
                dp[i-1][j-cost[i]] + memory[i] : dp[i-1][j];
            }
        }
    }
    for(int i=0; i<=10000; i++) {
        if(isOk == 1) break;
        for(int j=1; j<=n; j++) {
            if(dp[j][i] >= m) {
                printf("%d",i);
                isOk = 1;
                break;
            }
        }
    }

    return 0;
}
