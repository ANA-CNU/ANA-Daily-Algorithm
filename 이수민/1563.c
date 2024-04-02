#include <stdio.h>
#include <stdlib.h>
#define N 1000000
int n;
int dp[1001][3][2][3];
int sum = 0;
int main()
{
    scanf("%d",&n);
    dp[1][0][0][0] = 1;
    dp[1][1][1][0] = 1;
    dp[1][2][0][1] = 1;
    for(int i=2; i<=n; i++) {
        dp[i][0][0][0] = (dp[i-1][0][0][0] % N + dp[i-1][2][0][1] % N + dp[i-1][2][0][2] % N) % N;
        dp[i][0][1][0] = (dp[i-1][0][1][0] % N + dp[i-1][2][1][1] % N + dp[i-1][2][1][2] % N + dp[i-1][1][1][0] % N) % N;

        dp[i][1][1][0] = (dp[i-1][0][0][0] % N + dp[i-1][2][0][1] % N + dp[i-1][2][0][2] % N) % N;

        dp[i][2][0][1] = dp[i-1][0][0][0] % N;
        dp[i][2][0][2] = dp[i-1][2][0][1] % N;
        dp[i][2][1][1] = (dp[i-1][0][1][0] % N + dp[i-1][1][1][0] % N) % N;
        dp[i][2][1][2] = dp[i-1][2][1][1] % N;
    }

    for(int i=0; i<3; i++) for(int j=0; j<2; j++) for(int k=0; k<3; k++) {
        sum = (sum % N + dp[n][i][j][k] % N) % N;
    }
    printf("%d",sum);
    return 0;
}
