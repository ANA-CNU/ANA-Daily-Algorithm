#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

int dp[50001];

int fsq(int n) {
    int m;

    // 초기값
    dp[1] = 1;
    dp[2] = 2;

    // 점화식
    for (int i = 3; i <= n; i++) {
        m = dp[i - 1] + 1; // 보장되는 값(최소는 아님)
        for (int j = 2; j * j <= i; j++) {
            m = min(m, 1 + dp[i - j * j]); // 제곱수를 빼낸 나머지에 대한 dp값+1 들 중에 최솟값을 구함
        }
        dp[i] = m; // 최솟값 대입
    }

    return dp[n];
}

int main() {
    int n;
    cin >> n;
    cout << fsq(n);
}