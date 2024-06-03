#include <stdio.h>
#include <stdlib.h>
unsigned long long int dp[101][101];
unsigned long long int f(int n, int m) {
    if(dp[n][m]) return dp[n][m];
    if(n == 0 || m == 0) return dp[n][m] = 1;

    return dp[n][m] = f(n-1, m) + f(n, m-1);
}
void dfs(int n, int m, int k) {
    if(n == 0) {
        for(int i=0; i<m; i++) printf("z");
        return;
    }
    if(m == 0) {
        for(int i=0; i<n; i++) printf("a");
        return;
    }
    if(dp[n-1][m] >= k) {
        printf("a");
        dfs(n-1, m, k);
    }
    else {
        printf("z");
        dfs(n, m-1, k-dp[n-1][m]);
    }
}
int main()
{
    int n,m,k;
    scanf("%d %d %d",&n,&m,&k);
    unsigned long long int count = f(n, m);
    printf("count : %lld\n",count);
    if(count < k) printf("-1");
    else {
        dfs(n, m, k);
    }
    return 0;
}
