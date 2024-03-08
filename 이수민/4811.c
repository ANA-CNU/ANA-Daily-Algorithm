#include <stdio.h>
#include <stdlib.h>
long long int dp[31][31];
int a;
int main()
{
    for(int i=1; i<=30; i++) {
        dp[i][0] = 1;
    }
    for(int i=1; i<=30; i++) {
        for(int j=1; j<=i; j++) {

            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    for(;;) {
        scanf("%d",&a);
        if(!a) break;
        printf("%lld\n",dp[a][a]);
    }
    return 0;
}
