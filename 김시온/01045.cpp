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

class Disjoint_set {
public:
    int n;
    vector<int> parent, rank, size;

    Disjoint_set(int n) : n(n), parent(n), rank(n), size(n, 1) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    void merge(int u, int v) {
        u = find(u); v = find(v);
        if (u == v) return;
        if (rank[u] > rank[v]) swap(u, v);
        parent[u] = v;
        size[v] += size[u];
        if (rank[u] == rank[v]) rank[v]++;
    }

    int find(int u) {
        if (u == parent[u]) return u;
        return parent[u] = find(parent[u]);
    }
};

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, m;
    cin >> n >> m;
    vector<string> s(n);
    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }
    vector<pair<int, int>> edge;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (s[i][j] == 'Y') {
                edge.emplace_back(i, j);
            }
        }
    }
    Disjoint_set d(n);
    int cnt = 0;
    set<pair<int, int>> ret;
    for (int i = 0; i < SIZE(edge); i++) {
        pair<int, int> p = edge[i];
        if (d.find(p.first) != d.find(p.second)) {
            ret.insert(p);
            d.merge(d.find(p.first), d.find(p.second));
        }
    }
    if (SIZE(ret) != n - 1) {
        cout << "-1\n";
        return 0;
    }
    for (int i = 0; i < SIZE(edge); i++) {
        pair<int, int> p = edge[i];
        if (SIZE(ret) < m && !ret.count(p)) {
            ret.insert(p);
        }
    }
    if (SIZE(ret) != m) {
        cout << "-1\n";
        return 0;
    }
    vector<int> temp(n);
    for (auto& p : ret) {
        temp[p.first]++; temp[p.second]++;
    }
    for (int i = 0; i < n; i++) {
        cout << temp[i] << " \n"[i == n - 1];
    }
}
