#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sq = 320, sz = 100001, fwsz = 131072;

int kk;
int n, m, arr[sz], loc[sz],fenwick[fwsz];
ll res[sz], ans;

inline ll findSum(int idx){
    ll ret = 0;
    while (idx){
        ret += fenwick[idx];
        idx -= idx & - idx;
    }
    return ret;
}

inline ll findSum(int s, int e){
    return findSum(e) - findSum(s - 1);
}

inline void update(int idx, bool add){
    while (idx < fwsz){
        if (add) fenwick[idx]++;
        else fenwick[idx]--;
        idx += idx & -idx;
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
    ans += findSum(max(1, v - kk), min(sz - 1, v + kk));
    update(v, true);
}

inline void sub(const int& k){
    const int& v = arr[k];
    update(v, false);
    ans -= findSum(max(1, v - kk), min(sz - 1, v + kk));
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    // freopen("test.txt", "r", stdin);
    // freopen("out1.txt", "w", stdout);

    cin >> n >> kk;
    for (int i = 0; i < n; ++i) cin >> arr[i];
    cin >> m;
    for (int i = 0; i < m; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i, --queries[i].l, --queries[i].r;
    sort(queries, queries + m);

    int x, y;
    for (int i = 0; i < m; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (!i) x = l, y = l - 1;
        while (y < r) add(++y);
        while (y > r) sub(y--);
        while (x > l) add(--x);
        while (x < l) sub(x++);

        res[idx] = ans;
    }

    for (int i = 0; i < m; ++i){
        cout << res[i] << '\n';
    }
}