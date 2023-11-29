#include <bits/stdc++.h>
using namespace std;
int n;
int arr[1000][3];
int dp[1000][3];
int answer = 987654321;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        for(int j=0; j<3; j++) scanf("%d",&arr[i][j]);
    }

    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) dp[0][j] = 1001;
        dp[0][i] = arr[0][i];
        for(int j=1; j<n-1; j++) {
            for(int k=0; k<3; k++) {
                if(k == 0) dp[j][k] = min(dp[j-1][1], dp[j-1][2]) + arr[j][k];
                else if(k == 1) dp[j][k] = min(dp[j-1][0], dp[j-1][2]) + arr[j][k];
                else dp[j][k] = min(dp[j-1][0], dp[j-1][1]) + arr[j][k];
            }
        }
        if(i == 0) {
            dp[n-1][1] = min(dp[n-2][0], dp[n-2][2]) + arr[n-1][1];
            dp[n-1][2] = min(dp[n-2][0], dp[n-2][1]) + arr[n-1][2];
            answer = min(answer, min(dp[n-1][1], dp[n-1][2]));
        }
        else if(i == 1) {
            dp[n-1][0] = min(dp[n-2][1], dp[n-2][2]) + arr[n-1][0];
            dp[n-1][2] = min(dp[n-2][0], dp[n-2][1]) + arr[n-1][2];
            answer = min(answer, min(dp[n-1][0], dp[n-1][2]));
        }
        else {
            dp[n-1][0] = min(dp[n-2][1], dp[n-2][2]) + arr[n-1][0];
            dp[n-1][1] = min(dp[n-2][0], dp[n-2][2]) + arr[n-1][1];
            answer = min(answer, min(dp[n-1][0], dp[n-1][1]));
        }
    }
    printf("%d",answer);
    return 0;
}
