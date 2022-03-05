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

vector<int> p(1001);
vector<int> r(1001);

int find(int here) {
    if (p[here] == here) return here;
    return p[here] = find(p[here]);
}

void merge(int u, int v) {
    u = find(u); v = find(v);
    if (u == v) return;
    if (r[u] > r[v]) {
        swap(u, v);
    }
    p[u] = v;
    if (r[u] == r[v]) {
        r[v]++;
    }
}

vector<tuple<int, int, int>> edge;
int weight[1001][1001];

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        edge.emplace_back(w, u, v);
    }
    sort(ALL(edge));
    for (int i = 1; i <= n; i++) {
        p[i] = i;
    }
    for (int w = 200; w >= 1; w--) {
        bool flag = false;
        while (!edge.empty() && get<0>(edge.back()) == w) {
            int u = get<1>(edge.back());
            int v = get<2>(edge.back());
            merge(u, v);
            flag = true;
            edge.pop_back();
        }
        if (flag) {
            for (int u = 1; u <= n; u++) {
                for (int v = u + 1; v <= n; v++) {
                    if (find(u) == find(v)) {
                        weight[u][v] = max(weight[u][v], w);
                    }
                }
            }
        }
    }
    for (int i = 0; i < k; i++) {
        int u, v;
        cin >> u >> v;
        if (u > v) {
            swap(u, v);
        }
        cout << weight[u][v] << "\n";
    }
}

