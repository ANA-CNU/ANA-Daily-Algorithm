#include <stdio.h>
#include <stdlib.h>
long long int n;
long long int arr[101];
long long int dp[101][21];
int main()
{
    scanf("%lld",&n);
    for(int i=0; i<n; i++) {
        scanf("%lld",&arr[i]);
    }
    dp[0][arr[0]] = 1;
    for(int i=0; i<n-1; i++) {
        for(int j=0; j<=20; j++) {
            if(dp[i][j]) {
                if(j - arr[i+1] >= 0) dp[i+1][j-arr[i+1]] += dp[i][j];
                if(j + arr[i+1] <= 20) dp[i+1][j+arr[i+1]] += dp[i][j];
            }
        }
    }
    printf("%lld",dp[n-2][arr[n-1]]);
    return 0;
}
