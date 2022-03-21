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

const int MOD = 1e9 + 7;

vector<vector<int>> mul(const vector<vector<int>>& a, const vector<vector<int>>& b) {
    int n = SIZE(a);
    vector<vector<int>> ret = vector<vector<int>>(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                ret[i][j] = (ret[i][j] + (int)(((long long)a[i][k] * b[k][j]) % MOD)) % MOD;
            }
        }
    }
    return ret;
}

vector<vector<int>> pow(vector<vector<int>>& a, long long b) {
    if (b == 0) {
        int n = SIZE(a);
        vector<vector<int>> i(n, vector<int>(n));
        for (int k = 1; k < n; k++) {
            i[k][k] = 1;
        }
        return i;
    }
    if (b % 2) {
        return mul(a, pow(a, b - 1));
    }
    vector<vector<int>> p = pow(a, b / 2);
    return mul(p, p);
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, m, k;
    cin >> n >> m;
    vector<vector<int>> adj(n + 1, vector<int>());
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    cin >> k;
    vector<int> a(n + 1);
    a[1] = 1;
    vector<vector<int>> p(n + 1, vector<int>(n + 1));
    for (int here = 1; here <= n; here++) {
        for (int there : adj[here]) {
            p[here][there] = 1;
        }
    }
    p = pow(p, k);
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum = (sum + p[1][i] * a[i]) % MOD;
    }
    cout << sum << "\n";
}
