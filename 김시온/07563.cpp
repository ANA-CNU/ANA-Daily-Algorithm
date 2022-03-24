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

bool inRange(int y, int x) {
    return 0 <= y && y < 1025 && 0 <= x && x < 1025;
}

void solve() {
    int d, n;
    cin >> d >> n;
    vector<vector<int>> s(1025, vector<int>(1025));
    for (int i = 0; i < n; i++) {
        int y, x, p;
        cin >> y >> x >> p;
        for (int dy = -d; dy <= d; dy++) {
            for (int dx = -d; dx <= d; dx++) {
                int ny = y + dy, nx = x + dx;
                if (!inRange(ny, nx)) continue;
                s[ny][nx] += p;
            }
        }
    }
    int ry = 0, rx = 0;
    for (int y = 0; y < 1025; y++) {
        for (int x = 0; x < 1025; x++) {
            if (s[ry][rx] < s[y][x]) {
                ry = y, rx = x;
            }
        }
    }
    cout << ry << " " << rx << " " << s[ry][rx] << "\n";
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int tc;
    cin >> tc;
    while (tc--) {
        solve();
    }
}
