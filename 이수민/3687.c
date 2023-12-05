#include <stdio.h>
#include <stdlib.h>
long long int dp[101];
int main()
{
    int t,n;
    long long int arr[9] = {0, 0, 1, 7, 4, 2, 0, 8, 10};
    for(int i=0; i<=8; i++) dp[i] = arr[i];
    dp[6] = 6;
    for(int i=9; i<=100; i++) {
        dp[i] = dp[i-2] * 10 + arr[2];
        for(int j=3; j<=7; j++) {
            dp[i] = dp[i] > dp[i-j] * 10 + arr[j] ? dp[i-j] * 10 + arr[j] : dp[i];
        }
    }
    for(scanf("%d",&t);t--;puts("")) {
        scanf("%d",&n);
        printf("%lld ",dp[n]);
        if(n%2) {
            printf("7");
            for(int i=0; i<n/2-1; i++) printf("1");
        }
        else {
            for(int i=0; i<n/2; i++) printf("1");
        }
    }
    return 0;
}
