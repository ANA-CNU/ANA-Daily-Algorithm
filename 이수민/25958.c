#include <stdio.h>
#include <stdlib.h>
int check[5001];
long long int dp[5001][5001];
int main()
{
    for(int i=1; i<=5000; i++) {
        int sum = 0;
        int k = i;
        while(k) {
            sum += k%10;
            k /= 10;
        }
        if(i % sum == 0) check[i] = 1;
    }
    int m,k;
    scanf("%d %d",&m,&k);
    for(int i=1; i<=m; i++) dp[0][i] = 1;
    for(int i=1; i<=m; i++) {
        for(int j=1; j<=m; j++) {
            if(!check[j] || j > i) {dp[i][j] += dp[i][j-1]; continue;}
            dp[i][j] = dp[i-j][j] % k;
            dp[i][j] += dp[i][j-1];
            dp[i][j] = ((dp[i][j] % k) + (dp[i][j-1] % k)) % k;
        }
    }
    printf("%lld",dp[m][m] % k);
    return 0;
}
