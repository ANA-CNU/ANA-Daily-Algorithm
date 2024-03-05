#include <stdio.h>
#include <stdlib.h>
long long int dp[101], n;
int main()
{

    for(long long int i=1; i<=100; i++) {
        dp[i] = dp[i-1] + 1;
        for(long long int j=3; j<i; j++) {
            dp[i] = dp[i] < dp[i-j] * (j-1) ? dp[i-j] * (j-1) : dp[i];
        }
    }
    scanf("%lld",&n);
    printf("%lld",dp[n]);
    return 0;
}
