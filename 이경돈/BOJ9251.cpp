#include <iostream>
#include <string>
using namespace std;

int dp[1001][1001];
int lcs(string str1, string str2) {
    int m = str1.length();
    int n = str2.length();
    for (int i = 0; i <= m; i++)
        for (int j = 0;j <= n;j++) {
            if (i == 0 || j == 0)
                dp[i][j] = 0;
            else if (str1[i - 1] == str2[j - 1])
                dp[i][j] = 1 + dp[i - 1][j - 1];
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }

    return dp[m][n];
}

int main() {
    string str1, str2;
    cin >> str1 >> str2;

    cout << lcs(str1, str2);
}