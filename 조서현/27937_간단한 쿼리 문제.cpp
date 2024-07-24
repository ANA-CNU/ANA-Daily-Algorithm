#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sz = 200005, sq = 450;
int n, q, arr[sz];

// res: 쿼리의 연산 결과
// ans: 쿼리의 연산 결과의 변화량
// swp: 1부터 [i]까지의 연산 결과
ll res[sz], ans[sz], swp[sz];

// lo, loSq: [v]보다 작은 수들의 개수와 합
// hi, hiSq: [v]보다 큰 수들의 개수와 합
struct node
{
    ll cnt, sum;
    node operator+(const node& o){
        return {cnt + o.cnt, sum + o.sum};
    }
    node& operator+=(const int& v){
        cnt++; sum += v;
        return *this;
    }
} lo[sq * sq], hi[sq * sq], loSq[sq], hiSq[sq];

struct query
{
    int l, r, idx;
    bool operator<(const query &o) const {
        if (l / sq == o.l / sq) return r < o.r;
        return l / sq < o.l / sq;
    }
} queries[sz];

struct transfer
{
    int l, r, idx; bool add;
};
vector<transfer> transfers[sz];

inline void update(const int& v){
    for (int i = v + 1; i < v / sq * sq + sq; ++i) lo[i] += v;
    for (int i = v / sq + 1; i < sq; ++i) loSq[i] += v;
    for (int i = v - 1; i >= v / sq * sq; --i) hi[i] += v;
    for (int i = v / sq - 1; i >= 0; --i) hiSq[i] += v;
}

inline node findLowerThan(const int& v){
    return lo[v] + loSq[v / sq];
}

inline node findGreaterThan(const int& v){
    return hi[v] + hiSq[v / sq];
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    cin >> n >> q;
    for (int i = 1; i <= n; ++i) cin >> arr[i];

    for (int i = 1; i <= q; ++i) cin >> queries[i].l >> queries[i].r, queries[i].idx = i;
    sort(queries, queries + q);

    // 1. MO: 스위핑 중에 추가로 계산해야 하는 쿼리들 전처리
    int x = 1, y = 0;
    for (int i = 1; i <= q; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (y < r) transfers[x - 1].push_back({y + 1, r, idx, false}), y = r;
        if (x > l) transfers[y].push_back({l, x - 1, idx, true}), x = l;
        if (y > r) transfers[x - 1].push_back({r + 1, y, idx, true}), y = r;
        if (x < l) transfers[y].push_back({x, l - 1, idx, false}), x = l;
    }

    // 2. 스위핑: [1, i]까지의 연산 결과와, 추가로 계산해야 하는 쿼리들 계산
    for (int i = 1; i <= n; ++i){
        update(arr[i]);
        auto lw = findLowerThan(arr[i]), gt = findGreaterThan(arr[i]);
        swp[i] = swp[i - 1] + (lw.cnt * arr[i] - lw.sum) + (gt.sum - gt.cnt * arr[i]);

        for (const auto& t : transfers[i]){
            for (int j = t.l; j <= t.r; ++j){
                auto lw = findLowerThan(arr[j]), gt = findGreaterThan(arr[j]);
                ans[t.idx] += ((lw.cnt * arr[j] - lw.sum) + (gt.sum - gt.cnt * arr[j])) * (t.add ? 1 : -1);
            }
        }
    }

    // 3. MO: 스위핑 결과를 바탕으로 쿼리의 연산 결과 계산
    x = 1, y = 0;
    ll sum = 0;
    for (int i = 1; i <= q; ++i){
        const int &l = queries[i].l, &r = queries[i].r, &idx = queries[i].idx;
        if (y < r) ans[idx] += swp[r] - swp[y], y = r;
        if (x > l) ans[idx] -= swp[x - 1] - swp[l - 1], x = l;
        if (y > r) ans[idx] -= swp[y]- swp[r], y = r;
        if (x < l) ans[idx] += swp[l - 1] - swp[x - 1], x = l;

        sum += ans[idx];
        res[idx] = sum;
    }

    for (int i = 1; i <= q; ++i) cout << res[i] << '\n';
}