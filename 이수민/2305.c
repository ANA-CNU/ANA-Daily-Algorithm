#include <stdio.h>
#include <stdlib.h>
int n,k;
int f[41], f_s[41], dp[41];
int main()
{
    scanf("%d %d",&n, &k);
    f[0] = 1;
    f[1] = 1;
    f_s[0] = 1;
    f_s[1] = 2;
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=2; i<=n; i++)
    {
        f[i] = f[i-1] + f[i-2];
        f_s[i] = f_s[i-1] + f[i];
    }
    for(int i=3; i<=n; i++) {
        dp[i] = dp[i-1] + dp[i-2] + f_s[i-2] + f_s[i-3];
    }
    printf("%d",dp[n-k+1] * f[k-1] + dp[k] * f[n-k] - f[k-1] * f[n-k]);
    return 0;
}
