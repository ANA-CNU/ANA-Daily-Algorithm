#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << (x) << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << (x) << ", " << (y) << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << (x) << ", "    \
         << (y) << ", " << (z) << ")\n"
#define ALL(x) (x).begin(), (x).end()
#define SIZE(x) (int)((x).size())
using namespace std;

int n, m;
int s[100][100];

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

bool f(int t) {
    if (s[0][0] > t || s[n - 1][m - 1] > t) return false;
    queue<tuple<int, int, int>> q;
    vector<vector<vector<int>>> booked;
    booked.push_back(vector<vector<int>>());
    booked.push_back(vector<vector<int>>());
    for (int y = 0; y < n; y++) {
        booked[0].push_back(vector<int>(m));
        booked[1].push_back(vector<int>(m));
    }
    q.emplace(0, 0, 1);
    booked[1][0][0] = true;
    while (!q.empty()) {
        int y = get<0>(q.front());
        int x = get<1>(q.front());
        int k = get<2>(q.front());
        q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || s[ny][nx] > t || booked[k][ny][nx]) continue;
            q.emplace(ny, nx, k);
            booked[k][ny][nx] = true;
        }
        if (!k) continue;
        for (int d = 0; d < 4; d++) {
            int ny = y + 2 * dy[d]; int nx = x + 2 * dx[d]; int nk = false;
            if (!inRange(ny, nx) || s[ny][nx] > t || booked[nk][ny][nx]) continue;
            q.emplace(ny, nx, nk);
            booked[nk][ny][nx] = true;
        }
    }
    return booked[0][n - 1][m - 1] || booked[1][n - 1][m - 1];
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> s[i][j];
        }
    }
    int lo = 0; int hi = 1e9;
    if (f(lo)) {
        cout << 0 << "\n";
        return 0;
    }
    while (lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        if (f(mid)) hi = mid;
        else lo = mid;
    }
    cout << hi << "\n";
}
