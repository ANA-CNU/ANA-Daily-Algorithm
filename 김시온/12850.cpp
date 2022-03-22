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
    int n = 8, m = 11, k;
    cin >> k;
    vector<vector<int>> adj(n + 1, vector<int>());
    adj[1].push_back(2);
    adj[1].push_back(5);
    adj[2].push_back(1);
    adj[2].push_back(3);
    adj[2].push_back(6);
    adj[3].push_back(2);
    adj[3].push_back(6);
    adj[3].push_back(7);
    adj[3].push_back(4);
    adj[4].push_back(3);
    adj[4].push_back(7);
    adj[4].push_back(8);
    adj[5].push_back(1);
    adj[5].push_back(6);
    adj[6].push_back(2);
    adj[6].push_back(3);
    adj[6].push_back(5);
    adj[6].push_back(7);
    adj[7].push_back(3);
    adj[7].push_back(4);
    adj[7].push_back(6);
    adj[7].push_back(8);
    adj[8].push_back(4);
    adj[8].push_back(7);
    vector<int> a(n + 1);
    a[8] = 1;
    vector<vector<int>> p(n + 1, vector<int>(n + 1));
    for (int here = 1; here <= n; here++) {
        for (int there : adj[here]) {
            p[here][there] = 1;
        }
    }
    p = pow(p, k);
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum = (sum + p[8][i] * a[i]) % MOD;
    }
    cout << sum << "\n";
}
