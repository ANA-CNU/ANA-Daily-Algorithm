#include <bits/stdc++.h>

using namespace std;

constexpr int sz = 30010, sq = 173, MIN = -1e9, MAX = 1e9;
constexpr int segSz(int n) { int ret = 1; while (ret < n) ret <<= 1; return ret << 1; }
int n, q, arr[sz], res[sz], loc[sz];

struct node
{
    int mn, mx, v;
    node(int mn, int mx, int v) : mn(mn), mx(mx), v(v) {}
    node() : node(MAX, MIN, MAX) {}
    node operator+(const node& other) const{
        return {min(mn, other.mn), max(mx, other.mx), min(min(v, other.v), mx != MIN && other.mn != MAX ? abs(other.mn - mx) : MAX)};
    }
} seg[segSz(sz)];

node init(int s, int e, int i = 1){
    if (s == e){
        loc[s] = i;
        return seg[i] = {MAX, MIN, MAX};
    }
    const int m(s + e >> 1);
    const node &l = init(s, m, i << 1), &r = init(m + 1, e, i << 1 | 1);
    seg[i] = {l.mn == MAX ? r.mn : l.mn, r.mx == MIN ? l.mx : r.mx, min(min(l.v, r.v), l.mx != MIN && r.mn != MAX ? abs(r.mn - l.mx) : MAX)};
    return seg[i];
}

void update(int idx, bool add){
    int i = loc[idx];
    if (add) seg[i] = {idx, idx, MAX};
    else seg[i] = {MAX, MIN, MAX};
    while (i > 1){
        i >>= 1;
        const node &l = seg[i << 1], &r = seg[i << 1 | 1];
        seg[i] = {l.mn == MAX ? r.mn : l.mn, r.mx == MIN ? l.mx : r.mx, min(min(l.v, r.v), l.mx != MIN && r.mn != MAX ? abs(r.mn - l.mx) : MAX)};
    }
}

struct query
{
    int l, r, idx;
    bool operator<(const query &o) const {
        if (l / sq == o.l / sq) return r < o.r;
        return l / sq < o.l / sq;
    }
} queries[sz];

inline void add(const int& k){
    const int& v = arr[k];
    update(v - 1, true);
}

inline void sub(const int& k){
    const int& v = arr[k];
    update(v - 1, false);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("test.txt", "r", stdin);
    // freopen("out1.txt", "w", stdout);

    cin >> n >> q;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    init(0, n - 1);
    for (int i = 0; i < q; ++i) cin >> queries[i].l >> queries[i].r, queries[i].l--, queries[i].r--, queries[i].idx = i;
    sort(queries, queries + q);

    int x, y;
    for (int i = 0; i < q; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (!i) x = l, y = l - 1;

        while (y < r) add(++y);
        while (y > r) sub(y--);
        while (x > l) add(--x);
        while (x < l) sub(x++);

        res[idx] = seg[1].v;
    }

    for (int i = 0; i < q; ++i) cout << res[i] << '\n';
}