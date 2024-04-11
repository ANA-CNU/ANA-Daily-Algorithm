#include <iostream>
#include <cstring>
using namespace std;

int board[2][100000];
int dp[2][100000];
int n;

int func() {
    //초기 조건
    // 위에서 시작
    dp[0][0] = board[0][0];
    dp[1][1] = dp[0][0] + board[1][1];

    // 아래에서 시작 
    dp[1][0] = board[1][0];
    dp[0][1] = dp[1][0] + board[0][1];

    // 점화식
    // 그 직전 대각 or 직직전 대각 중 큰 거 선택
    for (int i = 2; i < n; i++) {
        dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + board[0][i];

        dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + board[1][i];
    }

    return max(dp[0][n - 1], dp[1][n - 1]);
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int k;

    cin >> k;

    while (k-- > 0) {
        cin >> n;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                cin >> board[i][j];
            }
        }

        cout << func() << "\n";

        memset(board, 0, sizeof(board));
        memset(dp, 0, sizeof(dp));
    }
}