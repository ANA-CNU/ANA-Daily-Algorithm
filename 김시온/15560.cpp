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

const int INF = 987654321;

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n, q, u, v;
    cin >> n >> q >> u >> v;
    vector<int> s(n);
    for (auto& x : s) {
        cin >> x;
    }
    vector<int> dp(n);
    for (int i = 0; i < q; i++) {
        int c, a, b;
        cin >> c >> a >> b;
        if (c == 0) {
            a--; b--;
            fill(ALL(dp), -INF);
            for (int i = a; i <= b; i++) {
                dp[i] = u * s[i] + v;
                if (i - 1 >= a) {
                    dp[i] = max(dp[i], dp[i - 1] + u * s[i] + v);
                }
            }
            cout << *max_element(ALL(dp)) - v << "\n";
        } else {
            a--;
            s[a] = b;
        }
    }
}
