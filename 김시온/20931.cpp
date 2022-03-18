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

int M = 1;
int last = 0;
const int MAX_N = 150000;
const int MAX_K = 20;
vector<vector<long long>> p = vector<vector<long long>>(MAX_N + 1, vector<long long>(MAX_K + 1));
vector<vector<long long>> d = vector<vector<long long>>(MAX_N + 1, vector<long long>(MAX_K + 1));

int query(int here, long long dist) {
    for (int k = MAX_K; k >= 0; k--) if (dist - d[here][k] >= 0) {
        dist -= d[here][k];
        here = p[here][k];
    }
    return last = here;
}

void update(int there, long long length) {
    int here = M;
    p[here][0] = there;
    for (int k = 1; k <= MAX_K; k++) {
        p[here][k] = p[p[here][k - 1]][k - 1];
    }
    d[here][0] = length;
    for (int k = 1; k <= MAX_K; k++) {
        d[here][k] = d[p[here][k - 1]][k - 1] + d[here][k - 1];
    }
    M++;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int q;
    cin >> q;
    while (q--) {
        string o;
        cin >> o;
        if (o == "query") {
            int here; long long dist;
            cin >> here >> dist;
            cout << query(here, dist) << "\n";
        } else {
            int there; long long length;
            cin >> there >> length;
            there = (there + last) % M;
            update(there, length);
        }
    }
}
