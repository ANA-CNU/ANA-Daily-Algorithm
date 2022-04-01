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

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n;
    cin >> n;
    vector<long long> b(1 << 11);
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        int mask = 0;
        for (int j = 0; j < SIZE(s); j++) {
            mask |= (1 << (s[j] - '0'));
        }
        b[mask]++;
    }
    long long ret = 0;
    for (int i = 0; i < SIZE(b); i++) {
        for (int j = i; j < SIZE(b); j++) {
            if ((i & j) == 0) continue;
            if (i == j) {
                ret += b[i] * (b[i] - 1) / 2;
            } else {
                ret += b[i] * b[j];
            }
        }
    }
    cout << ret << "\n";
}
