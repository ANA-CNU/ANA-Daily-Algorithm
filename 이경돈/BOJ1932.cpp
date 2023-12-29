#include <iostream>
using namespace std;

int board[500][500];
int dp[500][500];

int maxSum(int n) {
    // 1. 문제 : 꼭대기에서 최하층까지 이동했을 때 숫자의 합의 최댓값

    // 2. 초기 조건 : 삼각형의 양 끝은 초기화 가능
    dp[0][0] = board[0][0];
    for (int i = 0; i < n; i++) {
        dp[i][0] = dp[i-1][0] + board[i][0];
        dp[i][i] = dp[i - 1][i - 1] + board[i][i];
    }

    // 3. 점화식 : dp[i][j] = board[i][j] + max(dp[i-1][j], dp[i-1][j-1])
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < i; j++) {
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + board[i][j];
        }
    }

    int mVal = dp[n-1][0];
    for (int i = 1; i < n; i++) {
        mVal = max(mVal, dp[n - 1][i]);
    }
    
    return mVal;
}

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i+1; j++) {
            cin >> board[i][j];
        }
    }

    cout << maxSum(n);
}