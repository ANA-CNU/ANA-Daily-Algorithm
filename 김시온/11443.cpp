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
        vector<vector<int>> i(2, vector<int>(2));
        i[0][0] = i[1][1] = 1;
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
    long long n;
    cin >> n;
    if (!(n & 1)) n++;
    if (n == 0) {
        cout << 0 << "\n";
    }
    vector<vector<int>> a = vector<vector<int>>(2, vector<int>(2));
    a[0][0] = a[0][1] = a[1][0] = 1;
    vector<vector<int>> m = pow(a, n - 1);
    cout << m[0][0] - 1 << "\n";
}
