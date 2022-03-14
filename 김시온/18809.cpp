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
vector<vector<int>> s;
vector<pair<int, int>> p;

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

int bfs(vector<int>& pick) {
    queue<tuple<int, int, int>> q;
    vector<vector<vector<int>>> dist;
    for (int y = 0; y < n; y++) {
        dist.push_back(vector<vector<int>>());
        for (int x = 0; x < m; x++) {
            dist[y].push_back(vector<int>(2, -1));
        }
    }
    for (int t = 0; t <= 1; t++) {
        for (int i = 0; i < SIZE(pick); i++) if (pick[i] == t) {
            int y = p[i].first; int x = p[i].second;
            q.emplace(y, x, t);
            dist[y][x][t] = 0;
        }
    }
    while (!q.empty()) {
        int y = get<0>(q.front());
        int x = get<1>(q.front());
        int t = get<2>(q.front());
        q.pop();
        if (dist[y][x][t] == -2) continue;
        // 배양액이 도달하지 않은곳으로 퍼진다
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || s[ny][nx] == 0 ||
                dist[ny][nx][0] != -1 || dist[ny][nx][1] != -1) continue;            
            q.emplace(ny, nx, t);
            dist[ny][nx][t] = dist[y][x][t] + 1;
        }
        // 빨간색 배양액일 경우 꽃을 피울 수 있는지 확인
        if (t == 1) {
            // 방금 막 초록색 배양액이 도착한 곳이 있는지 확인
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d]; int nx = x + dx[d];
                if (!inRange(ny, nx) || dist[ny][nx][0] != dist[y][x][t] + 1) continue;            
                dist[ny][nx][0] = dist[ny][nx][1] = -2;
            }
        }
    }
    int cnt = 0;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (dist[y][x][0] == -2) {
                cnt++;
            }
        }
    }
    return cnt;
}

int btk(int i, int g, int r, vector<int>& pick) {
    if (i == SIZE(p)) {
        if (g || r) return 0;
        return bfs(pick);
    }
    int max = btk(i + 1, g, r, pick);
    if (g) {
        pick[i] = 0;
        max = ::max(max, btk(i + 1, g - 1, r, pick));
        pick[i] = -1;
    }
    if (r) {
        pick[i] = 1;
        max = ::max(max, btk(i + 1, g, r - 1, pick));
        pick[i] = -1;
    }
    return max;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int g, r;
    cin >> n >> m >> g >> r;
    s = vector<vector<int>>(n, vector<int>(m));
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            cin >> s[y][x];
            if (s[y][x] == 2) {
                p.emplace_back(y, x);
            }
        }
    }
    vector<int> pick = vector<int>(SIZE(p), -1);
    cout << btk(0, g, r, pick) << "\n";
}
