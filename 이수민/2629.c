#include <stdio.h>
#include <stdlib.h>
int n,m,a;
int w[31];
int dp[31][40001];
int main()
{
    scanf("%d",&n);
    for(int i=1; i<=n; i++) scanf("%d",&w[i]);

    for(int i=1; i<=n; i++) {
        dp[i][w[i]] = 1;
        for(int j=1; j<=40000; j++) {
            if(dp[i-1][j]) {
                dp[i][abs(w[i] - j)] = 1;
                dp[i][w[i] + j] = 1;
                dp[i][j] = 1;
            }
        }
    }
    scanf("%d",&m);
    for(int i=0; i<m; i++) {
        scanf("%d",&a);
        printf("%c ",dp[n][a] ? 'Y' : 'N');
    }
    return 0;
}
