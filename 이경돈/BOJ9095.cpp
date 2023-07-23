#include <iostream>
using namespace std;

int dp[12];
int fun(int n) {
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    
    for (int i = 4; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    
    return dp[n];
}

int main() {
    int k, n;
    cin >> k;
    while (k-- > 0) {
        cin >> n;
        cout << fun(n) << "\n";
    }
}