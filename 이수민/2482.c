#include <stdio.h>
#include <stdlib.h>
#define N 1000000003
int dp[1001][1001];
int f(int n, int k) {
    if(n/2 < k) return 0;
    if(dp[n][k]) return dp[n][k];
    if(k == 1) return dp[n][k] = n;
    return dp[n][k] = (f(n-1, k) % N + f(n-2, k-1) % N) % N;
}
int main()
{
    int n,k;
    scanf("%d %d",&n,&k);
    printf("%d",f(n, k));
    return 0;
}
