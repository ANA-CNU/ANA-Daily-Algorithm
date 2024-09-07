#include <bits/stdc++.h>
#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

int n, q, segSize;
constexpr int sq = 316;

struct node
{
    ll v, toAdd;
    node operator+(const node& other) const{
        return {max(v, other.v), 0};
    }
} seg[262144];

struct query
{
    int l, r, idx;
    bool operator<(const query& other) const{
        if (l / sq == other.l / sq) return r < other.r;
        return l / sq < other.l / sq;
    }
} queries[100000];

int loc[100000];

ll arr[100000], tmp[100000], res[100000];
unordered_map<ll, ll> comp, uncomp;

void initSegTree(int l, int r, int i = 1){
    if (l == r) {
        seg[i].toAdd = uncomp[l + 1];
        loc[l] = i;
        return;
    }
    int m = l + r >> 1;
    initSegTree(l, m, i << 1); initSegTree(m + 1, r, i << 1 | 1);
    seg[i] = seg[i << 1] + seg[i << 1 | 1];
}

ll findMax(int l, int r, int s, int e, int i = 1){
    if (e < l || r < s) return 0;
    if (s <= l && r <= e) return seg[i].v;
    int m = l + r >> 1;
    return max(findMax(l, m, s, e, i << 1), findMax(m + 1, r, s, e, i << 1 | 1));
}

void update(const int& idx, const bool& add){
    int i = loc[idx];
    if (add) seg[i].v += seg[i].toAdd;
    else seg[i].v -= seg[i].toAdd;
    while (i > 1)
        i >>= 1, seg[i] = seg[i << 1] + seg[i << 1 | 1];
}

inline void add(const int& k){
    const int& v = arr[k];
    update(v - 1, true);
}

inline void sub(const int& k){
    const int& v = arr[k];
    update(v - 1, false);
}

inline ll get(){
    // return findMax(0, segSize - 1, 0, segSize - 1);
    return seg[1].v;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    cin >> n >> q;
    for (int i = 0; i < n; ++i) cin >> arr[i], tmp[i] = arr[i];
    // 좌표 압축
    comp.reserve(n); uncomp.reserve(n);
    sort(tmp, tmp + n); int idx = 1;
    for (int i = 0; i < n; ++i){
        if (comp.find(tmp[i]) == comp.end())
            comp[tmp[i]] = idx, uncomp[idx] = tmp[i], idx++;
    }
    for (int i = 0; i < n; ++i) arr[i] = comp[arr[i]];

    segSize = comp.size();
    initSegTree(0, segSize - 1);

    for (int i = 0; i < q; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i, --queries[i].l, --queries[i].r;
    sort(queries, queries + q);

    int x, y;
    for (int i = 0; i < q; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (!i) x = l, y = l - 1;
        while (y < r) add(++y);
        while (y > r) sub(y--);
        while (x > l) add(--x);
        while (x < l) sub(x++);

        res[idx] = get();
    }

    for (int i = 0; i < q; ++i)
        cout << res[i] << '\n';
    
    return 0;
}