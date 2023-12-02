#include <stdio.h>
#include <stdlib.h>
int c,n;
int a[21];
int b[21];
int dp[21][1101];
int main()
{
    scanf("%d %d",&c,&n);
    for(int i=1; i<=n; i++) {
        scanf("%d %d",&a[i], &b[i]);
    }
    for(int j=0; j<=n; j++)for(int i=1; i<=c+100; i++) dp[j][i] = 987654321;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=c+100; j++) {
            if(b[i] > j) dp[i][j] = dp[i-1][j];
            else {
                dp[i][j] = dp[i-1][j] > dp[i][j-b[i]] + a[i] ? dp[i][j-b[i]] + a[i] : dp[i-1][j];
            }
        }
    }
    int answer = 987654321;
    for(int i=c; i<=c+100; i++) answer = answer > dp[n][i] ? dp[n][i] : answer;
    printf("%d",answer);
    return 0;
}
