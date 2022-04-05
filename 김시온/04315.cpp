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

int n;
vector<int> a;
vector<vector<int>> children;
vector<int> cache1, cache2;

const int INF = 987654321;

int dp1(int);
int dp2(int);

int dp1(int here) {
    if (cache1[here] != -1) return cache1[here];
    int sum = 0;
    for (int there : children[here]) {
        sum += dp1(there);
        sum += abs(dp2(there));
    }
    return cache1[here] = sum;
}

int dp2(int here) {
    if (cache2[here] != INF) return cache2[here];
    int sum = a[here] - 1;
    for (int there : children[here]) {
        sum += dp2(there);
    }
    return cache2[here] = sum;
}


void solve() {
    a = vector<int>(n + 1);
    children = vector<vector<int>>(n + 1);
    for (int i = 0; i < n; i++) {
        int here, m;
        cin >> here >> a[here] >> m;
        for (int j = 0; j < m; j++) {
            int there;
            cin >> there;
            children[here].push_back(there);
        }
    }
    cache1 = vector<int>(n + 1, -1);
    cache2 = vector<int>(n + 1, INF);
    int ret = 0;
    for (int here = 1; here <= n; here++) {
        ret = max(ret, dp1(here));
    }
    cout << ret << "\n";
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    while (true) {
        cin >> n;
        if (n == 0) break;
        solve();
    }
}
