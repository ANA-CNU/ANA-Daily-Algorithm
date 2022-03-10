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

int n;
vector<pair<int, int>> adj[100001];
vector<long long> dist;
vector<int> depth;
vector<vector<int>> parent;

const int MAX = 16;

void dfs(int here) {
    for (auto& edge : adj[here]) {
        int there = edge.first; int weight = edge.second;
        if (dist[there] == -1) {
            dist[there] = dist[here] + weight;
            depth[there] = depth[here] + 1;
            parent[0][there] = here;
            dfs(there);
        }
    }
}

int lca(int u, int v) {
    if (depth[u] < depth[v]) swap(u, v);
    int diff = depth[u] - depth[v];
    for (int i = 0; i <= MAX; i++) if (diff & (1 << i)) {
        u = parent[i][u];
    }
    if (u == v) return u;
    for (int i = MAX; i >= 0; i--) if (parent[i][u] != parent[i][v]) {
        u = parent[i][u];
        v = parent[i][v];
    }
    return parent[0][u];
}

int kth(int u, int v, int k) {
    int L = lca(u, v);
    if (u == L || v == L) {
        int D = abs(depth[u] - depth[v]) + 1;
        if (depth[u] < depth[v]) {
            swap(u, v);
            k = D - k + 1;
        }
        k--;
        for (int i = 0; i <= MAX; i++) if (k & (1 << i)) {
            u = parent[i][u];
        }
        return u;
    } else {
        int D = depth[u] + depth[v] + 1 - 2 * depth[L];
        int UL = depth[u] - depth[L] + 1;
        if (k > UL) {
            k = D - k + 1;
            swap(u, v);
        }
        k--;
        for (int i = 0; i <= MAX; i++) if (k & (1 << i)) {
            u = parent[i][u];
        }
        return u;
    }
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].emplace_back(v, w);
        adj[v].emplace_back(u, w);
    }
    dist = vector<long long>(n + 1, -1);
    dist[1] = 0;
    depth = vector<int>(n + 1, 0);
    parent = vector<vector<int>>(MAX + 1, vector<int>(n + 1));
    dfs(1);
    for (int k = 1; k <= MAX; k++) {
        for (int here = 1; here <= n; here++) {
            parent[k][here] = parent[k - 1][parent[k - 1][here]];
        }
    }
    int m;
    cin >> m;
    for (int i = 0; i < m; i++) {
        int o;
        cin >> o;
        if (o == 1) {
            int u, v;
            cin >> u >> v;
            cout << dist[u] + dist[v] - 2 * dist[lca(u, v)] << "\n";
        } else {
            int u, v, k;
            cin >> u >> v >> k;
            cout << kth(u, v, k) << "\n";
        }
    }
}
