#include <bits/stdc++.h>
#define deb(x) cout << #x << " : " << (x) << "\n"
#define deb_pair(x, y)                                                         \
    cout << "(" << #x << ", " << #y << ") : (" << (x) << ", " << (y) << ")\n"
#define deb_tuple(x, y, z)                                                     \
    cout << "(" << #x << ", " << #y << ", " << #z << ") : (" << (x) << ", " << (y) \
         << ", " << (z) << ")\n"
#define ALL(x) (x).begin(), (x).end()
#define SIZE(x) (int)((x).size())
using namespace std;

int n, m;
string s[20];
vector<pair<int, int>> pos;
vector<vector<vector<int>>> dist;

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

void bfs(int sy, int sx) {
    queue<pair<int, int>> q;
    q.emplace(sy, sx);
    vector<vector<int>> here_dist;
    for (int i = 0; i < n; i++) {
        here_dist.push_back(vector<int>(m, -1));
    }
    here_dist[sy][sx] = 0;
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || here_dist[ny][nx] != -1 || s[ny][nx] == 'x') continue;
            q.emplace(ny, nx);
            here_dist[ny][nx] = here_dist[y][x] + 1;
        }
    }
    dist.push_back(here_dist);
}

const int INF = 987654321;

int btk(int here, int count, vector<int>& visit) {
    if (count == SIZE(dist)) {
        return 0;
    }
    int min = INF;
    int y = pos[here].first; int x = pos[here].second;
    for (int there = 0; there < SIZE(dist); there++) if (!visit[there]) {
        int ny = pos[there].first; int nx = pos[there].second;
        if (dist[here][ny][nx] == -1) continue;
        visit[there] = true;
        min = ::min(min, dist[here][ny][nx] + btk(there, count + 1, visit));
        visit[there] = false;
    }
    return min;
}

int main() {
    // cin.tie(0);
    // ios_base::sync_with_stdio(0);
    while (true) {
        pos.clear();
        dist.clear();
        cin >> m >> n;
        if (n == 0) break;
        for (int i = 0; i < n; i++) {
            cin >> s[i];
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (s[y][x] == 'o') {
                    bfs(y, x);
                    pos.emplace_back(y, x);
                }
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (s[y][x] == '*') {
                    bfs(y, x);
                    pos.emplace_back(y, x);
                }
            }
        }
        vector<int> visit(SIZE(dist));
        visit[0] = true;
        int ret = btk(0, 1, visit);
        cout << (ret == INF ? -1 : ret) << "\n";
    }
    
}
