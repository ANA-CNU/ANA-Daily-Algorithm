#include <iostream>
#include <algorithm>
#include <set>
#include <string>

using namespace std;

int N, Q;
int arr[100001];
int seg[400001];

void init(int l, int r, int n) {
    if (l == r) {
        seg[n] = arr[l];
        return;
    }

    int mid = (l+r)/2;
    init(l, mid, n*2); init(mid+1, r, n*2+1);
    seg[n] = seg[n*2]*seg[n*2+1];
}

void update(int l, int r, int n, int i, int k) {
    if (l == i && i == r) {
        seg[n] = k;
        return;
    } else if (i < l || r < i) return;

    int mid = (l+r)/2;
    update(l, mid, n*2, i, k); update(mid+1, r, n*2+1, i, k);
    seg[n] = seg[n*2]*seg[n*2+1];
}

int getmul(int l, int r, int n, int u, int v) {
    if (u <= l && r <= v) return seg[n];
    else if (r < u || v < l) return 1;

    int mid = (l+r)/2;
    return getmul(l, mid, n*2, u, v)*getmul(mid+1, r, n*2+1, u, v);
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    while (!(cin >> N >> Q).eof()) {
        for (int i = 1; i < N+1; i++) {
            cin >> arr[i];
            if (arr[i] != 0) arr[i]/=abs(arr[i]);
        }

        init(1, N, 1);

        while (Q--) {
            char c; cin >> c;
            int u, v; cin >> u >> v;

            if (c == 'C') {
                if (v != 0) v/=abs(v);
                update(1, N, 1, u, v);
            } else {
                int ans = getmul(1, N, 1, u, v);
                if (ans > 0) cout << '+';
                else if (ans < 0) cout << '-';
                else cout << '0';
            }
        }

        cout << '\n';
    }
        
    return 0;
}