#include<bits/stdc++.h>
using namespace std;
int n,r,c;
int dp[501][501];
int matrix[501][2];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> n;
    for(int i=1; i<=n;i++){
        cin >> r >> c;
        matrix[i][0]=r;
        matrix[i][1]=c;
    }
    for (int i = 1; i < n; i++)
    {
        for (int j = 1; i + j <= n; j++)
        {
            dp[j][i + j] = 999999999;
            for (int k = j; k <= i + j; k++)
            {
                dp[j][i + j] = min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + matrix[j][0] * matrix[k][1] * matrix[i+j][1]);
            }
        }
    }
    cout << dp[1][n];
    return 0;
}
