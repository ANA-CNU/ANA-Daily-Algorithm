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
vector<string> s;
vector<pair<int, int>> pos;
vector<vector<vector<int>>> dist;
pair<int, int> end;

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

const int INF = 987654321;

int btk(int here, int picked, vector<int>& booked) {
    if (picked == SIZE(pos)) {
        return dist[here][::end.first][::end.second];
    }
    int min = INF;
    for (int there = 0; there < SIZE(pos); there++) {
        int y = pos[there].first; int x = pos[there].second;
        if (!booked[there]) {
            booked[there] = true;
            min = ::min(min, dist[here][y][x] + btk(there, picked + 1, booked));
            booked[there] = false;
        }
    }
    return min;
}

void bfs(int here) {
    queue<pair<int, int>> q;
    q.emplace(pos[here]);
    dist[here][pos[here].first][pos[here].second] = 0;
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || s[ny][nx] == '#' || dist[here][ny][nx] != -1) continue;
            q.emplace(ny, nx);
            dist[here][ny][nx] = dist[here][y][x] + 1;
        }
    }
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> m >> n;
    s = vector<string>(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (s[i][j] == 'S') {
                pos.emplace_back(i, j);
            }
            if (s[i][j] == 'E') {
                ::end.first = i;
                ::end.second = j;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (s[i][j] == 'X') {
                pos.emplace_back(i, j);
            }
        }
    }
    for (int k = 0; k < SIZE(pos); k++) {
        dist.push_back(vector<vector<int>>());
        for (int i = 0; i < n; i++) {
            dist[k].push_back(vector<int>(m, -1));
        }
        bfs(k);
    }
    vector<int> booked = vector<int>(SIZE(pos));
    booked[0] = true;
    cout << btk(0, 1, booked) << "\n";
}
