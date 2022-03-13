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
string s[1000];

const int dy[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
const int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};

bool inRange(int y, int x) { return 0 <= y && y < n && 0 <= x && x < m; }

void bfs(int sy, int sx, int k, vector<vector<int>>& booked, vector<int>& size) {
    queue<pair<int, int>> q;
    q.emplace(sy, sx);
    booked[sy][sx] = k;
    int cnt = 0;
    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        cnt++;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d]; int nx = x + dx[d];
            if (!inRange(ny, nx) || booked[ny][nx] != 0 || s[ny][nx] == '1') continue;
            q.emplace(ny, nx);
            booked[ny][nx] = k;
        }
    }
    size[k] = cnt;
}

void bfsAll() {
    vector<vector<int>> booked(n, vector<int>(m));
    vector<int> size(n * m);
    int k = 1;
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (s[y][x] == '0' && !booked[y][x]) {
                bfs(y, x, k, booked, size);
                k++;
            }
        }
    }
    for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
            if (s[y][x] == '1') {
                set<int> adj;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d]; int nx = x + dx[d];
                    if (!inRange(ny, nx)) continue;
                    adj.insert(booked[ny][nx]);
                }
                int sum = 1;
                for (auto& x : adj) {
                    sum = (sum + size[x]) % 10;
                }
                cout << sum;
            } else {
                cout << 0;
            }
        }
        cout << "\n";
    }
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    bfsAll();
}
