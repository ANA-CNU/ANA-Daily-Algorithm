#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << (x) << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << (x) << ", " << (y) << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << (x) << ", "    \
         << (y) << ", " << (z) << ")\n"
#define ALL(x) (x).begin(), (x).end()
#define SIZE(x) (int)((x).size())
#define OPEN(t) freopen("data.txt", (t), stdin)
using namespace std;

const int dy[4] = {1, 1, -1, -1};
const int dx[4] = {-1, 1, -1, 1};

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, m;
    cin >> n >> m;
    vector<string> s = vector<string>(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    vector<vector<vector<int>>> dp = vector<vector<vector<int>>>(4, vector<vector<int>>(n, vector<int>(m)));
    for (int y = n - 1; y >= 0; y--) {
        for (int x = 0; x < m; x++) {
            for (int d = 0; d < 2; d++) {
                if (s[y][x] == '0') continue;
                dp[d][y][x] = 1;
                int ny = y + dy[d]; int nx = x + dx[d];
                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    dp[d][y][x] += dp[d][ny][nx];
                }
            }
        }
    }
    for (int k = min((n + 1) / 2, (m + 1) / 2); k >= 1; k--) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (min(dp[0][y][x], dp[1][y][x]) < k) continue;
                int ny1 = y + (k - 1) * dy[0], ny2 = ny1;
                int nx1 = x + (k - 1) * dx[0], nx2 = x + (k - 1) * dx[1];
                if (0 <= ny1 && ny1 < n && 0 <= ny2 && ny2 < n && 0 <= nx1 && nx1 < m && 0 <= nx2 && nx2 < m) {
                    if (min(dp[1][ny1][nx1], dp[0][ny2][nx2]) >= k) {
                        cout << k << "\n";
                        return 0;
                    }
                }
            }
        }
    }
    cout << 0 << "\n";
}
