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

int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

void reduce(pair<int, int>& x) {
    int a = gcd(x.first, x.second);
    x.first /= a; x.second /= a;
}

// x가 0과 1사이인지 확인
bool inRange(pair<int, int>& x) {
    return 0 < x.first && x.first < x.second;
}

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int p, q, r;
    cin >> p >> q >> r;
    pair<int, int> x = make_pair(3 * p + r - 2 * q, 2 * (p + r));
    pair<int, int> y = make_pair(2 * q + p - r, 2 * (p + r));
    reduce(x); reduce(y);
    if (!inRange(x) || !inRange(y)) {
        cout << -1 << "\n";
    } else {
        cout << x.first << "/" << x.second << " " << y.first << "/" << y.second << "\n";
    }
}
