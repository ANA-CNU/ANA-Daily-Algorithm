#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sq = 320, sz = 100000;

ll n, m, segSize, cap, arr[sz], tmp[sz], loc[sz];
unordered_map<ll, ll> comp, uncomp;
ll res[sz], ans;

struct node
{
    ll sum, v;
    node operator+(const node& other) const{
        return {sum + other.sum, 0};
    }
} seg[262144 << 1];

ll findSum(int s, int e){
    s += cap - 1, e += cap - 1;
    ll ret = 0;
    while (s <= e){
        if (s & 1) ret += seg[s++].sum;
        if (!(e & 1)) ret += seg[e--].sum;
        s >>= 1, e >>= 1;
    }
    return ret;
    // if (e < l || r < s) return 0;
    // if (s <= l && r <= e) return seg[i].sum;
    // int m = l + r >> 1;
    // return findSum(l, m, s, e, i << 1) + findSum(m + 1, r, s, e, i << 1 | 1);
}

void update(int idx, bool add){
    int i = idx + cap - 1;
    if (add) seg[i].sum++;
    else seg[i].sum--;
    while (i > 1){
        i >>= 1;
        seg[i] = seg[i << 1] + seg[i << 1 | 1];
    }
}

void initSegTree(){
    // for (int i = 0; i < segSize; ++i){
    //     seg[i + cap].v = uncomp[i];
    // }
}

struct query
{
    int l, r, idx;
    bool operator<(const query &o) const {
        if (l / sq == o.l / sq) return r < o.r;
        return l / sq < o.l / sq;
    }
} queries[sz];

inline void add(const int& k, const bool left){
    const int& v = arr[k];
    update(v, true);
    if (left) ans += findSum(0, v - 1);
    else ans += findSum(v + 1, segSize - 1);
}

inline void sub(const int& k, const bool left){
    const int& v = arr[k];
    update(v, false);
    if (left) ans -= findSum(0, v - 1);
    else ans -= findSum(v + 1, segSize - 1);
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("test.txt", "r", stdin);
    // freopen("out1.txt", "w", stdout);

    cin >> n >> m;
    comp.reserve(n); uncomp.reserve(n);
    for (int i = 0; i < n; ++i) cin >> arr[i], tmp[i] = arr[i];
    // 좌표 압축
    sort(tmp, tmp + n); int cnt = 0;
    for (int i = 0; i < n; ++i) if (comp.find(tmp[i]) == comp.end()) comp[tmp[i]] = cnt, uncomp[cnt] = tmp[i], cnt++;
    for (int i = 0; i < n; ++i) arr[i] = comp[arr[i]];

    segSize = comp.size(); cap = 1;
    while (cap < segSize) cap <<= 1;
    cap <<= 1;

    initSegTree();

    for (int i = 0; i < m; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i, --queries[i].l, --queries[i].r;
    sort(queries, queries + m);

    int x, y;
    for (int i = 0; i < m; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (!i) x = l, y = l - 1;
        while (y < r) add(++y, false);
        while (y > r) sub(y--, false);
        while (x > l) add(--x, true);
        while (x < l) sub(x++, true);

        res[idx] = ans;
    }

    for (int i = 0; i < m; ++i){
        cout << res[i] << '\n';
    }
    cout.flush();
}