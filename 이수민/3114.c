#include <stdio.h>
#include <stdlib.h>
int n,m,a[1501][1501],a_sum[1501][1501],b[1501][1501],b_sum[1501][1501],dp[1501][1501],sum[1501][1501];
char arr[4];
int main()
{
    scanf("%d %d ",&n,&m);
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            scanf("%s",&arr);
            if(arr[0] =='A') {
                a[i][j] = atoi(arr+1);
            }
            else {
                b[i][j] = atoi(arr+1);
            }
        }
    }

    for(int j=0; j<m; j++) {
        for(int i=n-1; i>0; i--) {
            a_sum[i-1][j] = a_sum[i][j] + a[i][j];
        }
    }

    for(int j=1; j<m; j++) {
        for(int i=0; i<n; i++) {
            b_sum[i+1][j] = b_sum[i][j] + b[i][j];
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            sum[i][j] = a_sum[i][j] + b_sum[i][j];
        }
    }

    for(int i=0; i<n; i++) {
        dp[i][0] = sum[i][0];
    }

    for(int j=1; j<m; j++) {
        for(int i=0; i<n; i++) {
            if(i == 0) {
                dp[i][j] = dp[i][j-1] + sum[i][j];
            }
            else {
                dp[i][j] = dp[i][j-1] + sum[i][j];
                if(dp[i][j] < dp[i-1][j-1] + sum[i][j]) dp[i][j] = dp[i-1][j-1] + sum[i][j];
                if(dp[i][j] < dp[i-1][j] - a[i][j]) dp[i][j] = dp[i-1][j] - a[i][j];
            }
        }
    }

    printf("%d",dp[n-1][m-1]);
    return 0;
}
