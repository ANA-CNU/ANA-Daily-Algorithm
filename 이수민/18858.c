#include <stdio.h>
#include <stdlib.h>
#define N 998244353
int n,m;
long long int answer;
long long int dp[1001][101][3];
int main()
{
    scanf("%d %d",&n,&m);
    if(n == 1) printf("%d",m);
    else if(n == 2) printf("%d",m * m);
    else {
        for(int i=1; i<=m; i++) {
            dp[2][i][0] = i - 1;
            dp[2][i][1] = 1;
            dp[2][i][2] = m - i;
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                for(int k=1; k<j; k++) {
                    dp[i][j][0] = ((dp[i][j][0] % N) + (dp[i-1][k][0] % N) + (dp[i-1][k][1] % N) + (dp[i-1][k][2] % N)) % N;
                }
                dp[i][j][1] = ((dp[i][j][1] % N) + (dp[i-1][j][0] % N) + (dp[i-1][j][1] % N) + (dp[i-1][j][2] % N)) % N;
                for(int k=m; k>j; k--) {
                    dp[i][j][2] = ((dp[i][j][2] % N) + (dp[i-1][k][1] % N) + (dp[i-1][k][2] % N)) % N;
                }
            }
        }

        for(int i=1; i<=m; i++) {
            answer = ((answer % N) + (dp[n][i][0] % N) + (dp[n][i][1] % N) + (dp[n][i][2] % N)) % N;
        }
        printf("%d",answer);
    }

    return 0;
}
