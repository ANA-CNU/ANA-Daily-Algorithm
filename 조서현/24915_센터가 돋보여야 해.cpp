#include <bits/stdc++.h>

using namespace std;

constexpr int sz = 333'333, sgsz = 1 << (33 - __builtin_clz(sz)), dummy = 1e9;

struct node
{
    int mn, mx, mnmx, mxmn, res;
    node(int v) {
        mn = mx = v;
        mnmx = mxmn = res = -dummy;
    }
    node() : node(0){
        mn = dummy;
        mx = -dummy;
    }
    node operator+(const node& o) const {
        node ret;
        ret.mn = min(mn, o.mn);
        ret.mx = max(mx, o.mx);
        ret.mnmx = max({mnmx, o.mnmx, o.mx - mn});
        ret.mxmn = max({mxmn, o.mxmn, mx - o.mn});
        ret.res = max({res, o.res, mnmx - o.mn, o.mxmn - mn});
        return ret;
    }
} tree[sgsz];

int arr[sz], loc[sz];

node& init(int s, int e, int i = 1){
    if (s == e){
        loc[s] = i;
        return tree[i] = node(arr[s]);
    }
    int m = s + e >> 1;
    return tree[i] = init(s, m, i << 1) + init(m + 1, e, i << 1 | 1);
}

void update(int idx, int v){
    int i = loc[idx];
    tree[i] = node(v);
    while (i >>= 1)
        tree[i] = tree[i << 1] + tree[i << 1 | 1];
}

node query(int s, int e, int l, int r, int i = 1){
    if (r < s || e < l) return node();
    if (l <= s && e <= r) return tree[i];
    int m = s + e >> 1;
    return query(s, m, l, r, i << 1) + query(m + 1, e, l, r, i << 1 | 1);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, q; cin >> n >> q;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    init(0, n - 1);
    
    while (q--){
        int a, b, c; cin >> a >> b >> c;
        if (a == 1) update(b - 1, c);
        else cout << query(0, n - 1, b - 1, c - 1).res << '\n';
    }
}