#include <stdio.h>
#include <stdlib.h>
#define N 1000000000
int n;
int dp[101][10][1024];
int main()
{
    scanf("%d",&n);

    for(int i=1; i<=n; i++) {
        for(int j=0; j<=9; j++) {
            if(i == 1) {
                if(j == 0) continue;
                dp[i][j][1<<j] = 1;
                continue;
            }
            if(j == 0) {
                for(int k=0; k<1024; k++) {
                    if(dp[i-1][j+1][k]) {
                        dp[i][j][k|(1<<j)] += dp[i-1][j+1][k] % N;
                    }
                }
            }
            else if(j == 9) {
                for(int k=0; k<1024; k++) {
                    if(dp[i-1][j-1][k]) {
                        dp[i][j][k|(1<<j)] += dp[i-1][j-1][k] % N;
                    }
                }
            }
            else {
                for(int k=0; k<1024; k++) {
                    if(dp[i-1][j-1][k]) {
                        dp[i][j][k|(1<<j)] += dp[i-1][j-1][k] % N;
                    }
                    if(dp[i-1][j+1][k]) {
                        dp[i][j][k|(1<<j)] += dp[i-1][j+1][k] % N;
                    }
                }
            }
        }
    }
    int answer = 0;
    for(int i=0; i<=9; i++) {
        answer = ((answer % N) + (dp[n][i][1023] % N)) % N;
    }
    printf("%d",answer);
    return 0;
}
