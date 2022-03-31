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

int n, m, k;
vector<string> s;
vector<vector<int>> cost;
vector<pair<int, int>> src;

const int INF = 987654321;
const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

void bfs(int here) {
    int sy = src[here].first; int sx = src[here].second;
    queue<pair<int, int>> q;
    vector<vector<int>> dist(n, vector<int>(m, -1));
    q.emplace(sy, sx);
    dist[sy][sx] = 0;
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || s[ny][nx] == 'X' || dist[ny][nx] != -1) continue;
            q.emplace(ny, nx);
            dist[ny][nx] = dist[y][x] + 1;
        }
    }
    for (int there = 0; there < k; there++) {
        int ny = src[there].first; int nx = src[there].second;
        if (dist[ny][nx] != -1) {
            cost[here][there] = cost[there][here] = dist[ny][nx];
        }
    }
}

int bfc(int here, int mask) {
    if (__builtin_popcount(mask) == 6) {
        return 0;
    }
    int min = INF;
    for (int there = 0; there < k; there++) {
        if ((mask & (1 << there)) == 0) {
            mask |= (1 << there);
            min = ::min(min, cost[here][there] + bfc(there, mask));
            mask &= ~(1 << there);
        }
    }
    return min;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    s = vector<string>(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    src = vector<pair<int, int>>(21);
    k = 1;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (s[y][x] == 'K') {
                src[k].first = y;
                src[k].second = x;
                k++;
            } else if (s[y][x] == 'S') {
                src[0].first = y;
                src[0].second = x;
            }
        }
    }
    cost = vector<vector<int>>(21, vector<int>(21, INF));
    for (int here = 0; here < k; here++) {
        bfs(here);
    }
    int ret = bfc(0, 1);
    cout << (ret == INF ? -1 : ret) << "\n";
}
