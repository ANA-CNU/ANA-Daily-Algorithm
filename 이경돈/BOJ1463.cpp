#include <iostream>
using namespace std;

int dp[1000001];    

int toOne(int n) {
    if (n == 1) return 0;
    if (dp[n] == -1) {
        if (n % 6 == 0)
            dp[n] = 1 + min(min(toOne(n / 3), toOne(n/2)), toOne(n - 1));
        else if (n % 3 == 0)
            dp[n] = 1 + min(toOne(n / 3), toOne(n - 1));
        else if (n % 2 == 0)
            dp[n] = 1 + min(toOne(n / 2), toOne(n - 1));
        else
            dp[n] = 1 + toOne(n-1);
    }

    return dp[n];
}

int main() {
    fill_n(dp, 1000001, -1);
    int n;
    cin >> n;
    cout << toOne(n);
}