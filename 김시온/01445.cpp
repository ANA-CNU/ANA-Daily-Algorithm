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
vector<string> s;

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};
const int INF = 987654321;

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

pair<int, int> cost(int y, int x) {
    pair<int, int> ret;
    if (s[y][x] == 'g') {
        ret.first++;
        return ret;
    }
    if (s[y][x] == '.') {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx)) continue;
            if (s[ny][nx] == 'g') {
                ret.second = 1;
            }
        }
    }
    return ret;
}

pair<int, int> dijkstra() {
    priority_queue<tuple<int, int, int, int>> pq;
    vector<vector<pair<int, int>>> dist;
    for (int i = 0; i < n; i++) {
        dist.push_back(vector<pair<int, int>>());
        for (int j = 0; j < m; j++) {
            dist[i].emplace_back(INF, INF);
        }
    }
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (s[y][x] == 'S') {
                pq.emplace(0, 0, y, x);
            }
        }
    }
    while (!pq.empty()) {
        int a = -get<0>(pq.top());
        int b = -get<1>(pq.top());
        int y = get<2>(pq.top());
        int x = get<3>(pq.top());
        pair<int, int> here_cost = make_pair(a, b);
        pq.pop();
        if (dist[y][x] < here_cost) continue;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx)) continue;
            pair<int, int> there_cost = cost(ny, nx);
            there_cost.first += here_cost.first;
            there_cost.second += here_cost.second;
            if (dist[ny][nx] > there_cost) {
                dist[ny][nx] = there_cost;
                pq.emplace(-there_cost.first, -there_cost.second, ny, nx);
            }
        }
    }
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (s[y][x] == 'F') {
                return dist[y][x];
            }
        }
    }
    return make_pair(INF, INF);
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    s = vector<string>(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    pair<int, int> ret = dijkstra();
    cout << ret.first << " " << ret.second << "\n";
}
