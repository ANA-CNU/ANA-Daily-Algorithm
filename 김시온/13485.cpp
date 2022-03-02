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

int n = 10, m;
char s[10][100001];
bool booked[10][100001];
tuple<int, int, int> prev[10][100001][2];
int ey = -1, ex = -1, ek = -1;

void bfs() {
    queue<tuple<int, int, int>> q;
    q.emplace(n - 1, 0, 0);
    booked[n - 1][0] = true;
    while (!q.empty()) {
        int y = get<0>(q.front());
        int x = get<1>(q.front());
        int k = get<2>(q.front());
        q.pop();
        if (x == m - 1) {
            ey = y; ex = x; ek = k;
            break;
        }
        // 오른쪽으로 이동하는 경우
        if ((y == 0 || y == n - 1) && s[y][x + 1] == '.' && !booked[y][x + 1]) {
            q.emplace(y, x + 1, y == 0);
            booked[y][x + 1] = true;
            ::prev[y][x + 1][y == 0] = make_tuple(y, x, k);
        }
        // 제트팩 사용
        // 위로 올라가는 경우
        if (y - 1 >= 0 && s[y - 1][x + 1] == '.' && !booked[y - 1][x + 1]) {
            q.emplace(y - 1, x + 1, 1);
            booked[y - 1][x + 1] = true;
            ::prev[y - 1][x + 1][1] = make_tuple(y, x, k);
        }
        // 제트팩 미사용
        // 아래로 내려가는 경우
        if (y + 1 < n && s[y + 1][x + 1] == '.' && !booked[y + 1][x + 1]) {
            q.emplace(y + 1, x + 1, 0);
            booked[y + 1][x + 1] = true;
            ::prev[y + 1][x + 1][0] = make_tuple(y, x, k);
        }
    }
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> m;
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    bfs();
    assert(ey != -1);
    vector<pair<int, int>> path;
    while (ex != 0) {
        path.emplace_back(ex, ek);
        int ny = get<0>(::prev[ey][ex][ek]);
        int nx = get<1>(::prev[ey][ex][ek]);
        int nk = get<2>(::prev[ey][ex][ek]);
        ey = ny; ex = nx; ek = nk;
    }
    path.emplace_back(ex, ek);
    reverse(ALL(path));
    vector<pair<int, int>> order;
    int last = -1;
    for (int i = 1; i < SIZE(path); i++) {
        if (path[i - 1].second == 0 && path[i].second == 1) {
            last = path[i - 1].first;
        }
        if (path[i - 1].second == 1 && path[i].second == 0) {
            order.emplace_back(last, path[i - 1].first - last);
            last = -1;
        }
    }
    if (last != -1) {
        order.emplace_back(last, m - 1 - last);
    }
    cout << SIZE(order) << "\n";
    for (auto& x : order) {
        cout << x.first << " " << x.second << "\n";
    }
}
