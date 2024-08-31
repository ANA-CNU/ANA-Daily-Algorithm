#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

// const int maxn = 10'000, sz = 30'001, sgsz = 1 << (33 - __builtin_clz(sz));
const int maxn = 100, sz = 100, sgsz = 1 << (33 - __builtin_clz(sz));

struct rectangle
{
    int x1, y1, x2, y2;
    rectangle(int x1, int y1, int x2, int y2) : x1(x1), y1(y1), x2(x2), y2(y2) {}
    rectangle() {}
} rects[maxn];

struct sweeping
{
    int y1, y2; bool isStart;
};
vector<sweeping> swp[sz]; // 각 x좌표에 대한 스위핑 정보

struct node
{
    int itv, sum, cnt;
    int eval() const { return cnt ? itv : sum; }
    node(int itv = 0, int sum = 0, int cnt = 0) : itv(itv), sum(sum), cnt(cnt) {}
    node operator+(const node& o) const { return {itv + o.itv, eval() + o.eval(), 0}; }
} tree[sgsz << 1];

int loc[sz << 1];

node& init(int s, int e, int i = 1) {
    if (s == e){
        loc[s] = i;
        return tree[i] = node(1);
    }
    int m = (s + e) >> 1;
    return tree[i] = init(s, m, i << 1) + init(m + 1, e, i << 1 | 1);
}

void update(int s, int e, int l, int r, bool add, int i = 1){
    if (r < s || e < l) return;
    if (l <= s && e <= r){
        tree[i].cnt += add ? 1 : -1;
        if (tree[i].cnt) tree[i].sum = tree[i].itv;
        else tree[i].sum = s == e ? 0 : tree[i << 1].eval() + tree[i << 1 | 1].eval();
        return;
    }
    int m = (s + e) >> 1;
    update(s, m, l, r, add, i << 1); update(m + 1, e, l, r, add, i << 1 | 1);
    if (tree[i].cnt) tree[i].sum = tree[i].itv;
    else tree[i] = tree[i << 1] + tree[i << 1 | 1];
}

node query(int s, int e, int l, int r , int i = 1){
    if (r < s || e < l) return {0, 0};
    if (l <= s && e <= r) return tree[i];
    int m = (s + e) >> 1;
    return query(s, m, l, r, i << 1) + query(m + 1, e, l, r, i << 1 | 1);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n; cin >> n;
    for (int i = 0; i < n; ++i) cin >> rects[i].x1 >> rects[i].y1 >> rects[i].x2 >> rects[i].y2;

    // 스위핑
    for (int i = 0; i < n; ++i){
        swp[rects[i].x1].push_back({rects[i].y1, rects[i].y2, true});
        swp[rects[i].x2].push_back({rects[i].y1, rects[i].y2, false});
    }
    
    // 세그먼트 트리 초기화
    init(0, sz - 1);

    // 각 x좌표에 대해서 연산
    ll ans = 0;
    for (int i = 0; i < sz; ++i) {
        for (auto& s : swp[i]) {
            update(0, sz - 1, s.y1, s.y2 - 1, s.isStart);
        }
        ans += tree[1].eval();
    }

    cout << ans << '\n';
}