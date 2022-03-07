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
vector<int> s;
vector<pair<int, int>> adj[100001];

// 최대 공부량 k로 m개 이상을 공부할 수 있는지 여부
bool f(int k) {
    queue<int> q;
    vector<int> d = s;
    for (int i = 1; i <= n; i++) {
        if (d[i] <= k) {
            q.push(i);
        }
    }
    while (!q.empty()) {
        int here = q.front();
        q.pop();
        for (auto& edge : adj[here]) {
            int there = edge.first; int cost = edge.second;
            if (d[there] > k && d[there] - cost <= k) {
                q.push(there);
            }
            d[there] -= cost;
        }
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (d[i] <= k) {
            cnt++;
        }
    }
    return cnt >= m;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n >> m;
    s = vector<int>(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> s[i];
    }
    int r;
    cin >> r;
    for (int i = 0; i < r; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
    }
    int lo = 0; int hi = 1e8;
    while (lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        if (f(mid)) hi = mid;
        else lo = mid;
    }
    cout << hi << "\n";
}
