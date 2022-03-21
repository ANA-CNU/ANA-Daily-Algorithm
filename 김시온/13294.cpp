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

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    // freopen("data.txt", "r", stdin);
    string s;
    cin >> s;
    if (SIZE(s) <= 6) {
        int x = stoi(s); int r = 1;
        for (int k = 1; k <= 9; k++) {
            r *= k;
            if (x == r) {
                cout << k << "\n";
                return 0;
            }
        }
    } else {
        double sum = 0; int k = 1;
        while (sum + 1 < SIZE(s)) {
            sum += log10(k);
            k++;
        }
        cout << k - 1 << "\n";
    }
}
