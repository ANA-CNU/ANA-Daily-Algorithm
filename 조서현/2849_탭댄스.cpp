#include <bits/stdc++.h>

using namespace std;

constexpr int sz = 200001, segSz = 1 << 19;

struct node
{
    bool lv, rv;
    int lmx, rmx, mx, itv;
    node(bool v){
        lv = rv = v;
        lmx = rmx = mx = 1;
        itv = 1;
    }
    node(){
        lv = rv = false;
        lmx = rmx = mx = 0;
        itv = 1;
    }

    node operator+(const node& rhs) const{
        node ret; ret.itv = itv + rhs.itv;
        ret.lv = lv, ret.rv = rhs.rv;
        ret.lmx = lmx, ret.rmx = rhs.rmx;
        if (itv == lmx && rv != rhs.lv) ret.lmx += rhs.lmx;
        if (rhs.itv == rhs.rmx && rv != rhs.lv) ret.rmx += rmx;
        ret.mx = max(max(mx, rhs.mx), rv != rhs.lv ? rmx + rhs.lmx : 0);
        return ret;
    }
} seg[segSz];

node& build(int s, int e, int i = 1){
    if (s == e){
        return seg[i] = node(false);
    }
    int m = s + e >> 1;
    return seg[i] = build(s, m, i << 1) + build(m + 1, e, i << 1 | 1);
}

void flip(int s, int e, int l, int r, int i = 1){
    if (r < s || e < l) return;
    if (l <= s && e <= r){
        assert(s == e);
        seg[i] = node(!seg[i].lv);
        return;
    }
    const int m = s + e >> 1;
    flip(s, m, l, r, i << 1); flip(m + 1, e, l, r, i << 1 | 1);
    seg[i] = seg[i << 1] + seg[i << 1 | 1];
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, q; cin >> n >> q;

    build(0, n - 1);
    for (int i = 0; i < q; ++i){
        int k; cin >> k; --k;
        flip(0, n - 1, k, k);
        auto& res = seg[1];
        cout << max({res.mx, res.lmx, res.rmx}) << '\n';
    }
}