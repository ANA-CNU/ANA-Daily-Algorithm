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

vector<pair<int, int>> adj[1001];
int cache[1001];

const int INF = 987654321;

int dp(int here) {
    if (here == 1) return 0;
    if (cache[here]) return cache[here];
    int max = -INF;
    for (auto& edge : adj[here]) {
        int there = edge.first; int cost = edge.second;
        max = ::max(max, cost + dp(there));
    }
    return cache[here] = max;
}

void reconstruct(int here) {
    if (here == 1) return;
    cout << here << " ";
    int max = -INF; int num = 0;
    for (auto& edge : adj[here]) {
        int there = edge.first; int cost = edge.second;
        if (max < cost + dp(there)) {
            max = cost + dp(there);
            num = there;
        }
    }
    reconstruct(num);
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
    }
    int max = -INF;
    for (auto& edge : adj[1]) {
        int there = edge.first; int cost = edge.second;
        max = ::max(max, cost + dp(there));
    }
    cout << max << "\n";
    cout << 1 << " ";
    max = -INF; int num = 0;
    for (auto& edge : adj[1]) {
        int there = edge.first; int cost = edge.second;
        if (max < cost + dp(there)) {
            max = cost + dp(there);
            num = there;
        }
    }
    reconstruct(num);
    cout << 1 << "\n";
}
