#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int cost[1000][3];
int dp[1000][3];

int func() {
    // 1.초기조건
    for (int i = 0; i < 3; i++)
        dp[0][i] = cost[0][i];

    // 2.점화식
    for (int i = 1; i < n; i++) {
        dp[i][0] = cost[i][0] + min(dp[i - 1][1], dp[i - 1][2]);
        dp[i][1] = cost[i][1] + min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = cost[i][2] + min(dp[i - 1][0], dp[i - 1][1]);
    }


    return min({ dp[n - 1][0], dp[n - 1][1], dp[n - 1][2] });
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }

    cout << func();
}