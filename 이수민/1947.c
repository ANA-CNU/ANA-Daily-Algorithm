#include <stdio.h>
#include <stdlib.h>
#define N 1000000000
int n;
long long int dp[1000001];
int main()
{
    dp[1] = 0;
    dp[2] = 1;
    scanf("%d",&n);
    for(int i=3; i<=n; i++) {
        dp[i] = (((i-1) % N)*((dp[i-1] + dp[i-2]) % N)) % N;
    }
    printf("%lld",dp[n]);
    return 0;
}
