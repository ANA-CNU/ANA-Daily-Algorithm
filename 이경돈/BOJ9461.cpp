#include <iostream>
using namespace std;

long long dp[101];

long long triangle(int n) {
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    dp[6] = 3;

    for (int i = 7; i <= n; i++)
        dp[i] = dp[i - 5] + dp[i - 1];

    return dp[n];
}

int main() {
    int k, n;
    cin >> k;
    
    while (k-- > 0) {
        cin >> n;

        cout << triangle(n) << "\n";
    }
}