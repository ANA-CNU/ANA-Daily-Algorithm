#include <bits/stdc++.h>

using namespace std;

constexpr int sz = 100010, sgsz = 1 << 18;

int leftIdx[sz], rightIdx[sz], seg[sgsz], lazy[sgsz];
vector<int> children[sz];

int dfs(int node, int idx){
    leftIdx[node] = idx++;
    for (auto& child : children[node]){
        idx = dfs(child, idx);
    }
    return rightIdx[node] = idx;
}

int build(int s, int e, int i = 1){
    if (s == e) return seg[i] = 1;
    const int m = (s + e) >> 1;
    return seg[i] = build(s, m, i << 1) + build(m + 1, e, i << 1 | 1);
}

void propagate(int s, int e, int i){
    if (lazy[i] == 0) return;
    seg[i] = lazy[i] == 1 ? (e - s + 1) : 0;
    if (s != e)
        lazy[i << 1] = lazy[i << 1 | 1] = lazy[i];
    lazy[i] = 0;
}

void update(int s, int e, int l, int r, int v, int i = 1){
    propagate(s, e, i);
    if (r < s || e < l) return;
    if (l <= s && e <= r){
        lazy[i] = v;
        propagate(s, e, i);
        return;
    }
    const int m = (s + e) >> 1;
    update(s, m, l, r, v, i << 1); update(m + 1, e, l, r, v, i << 1 | 1);
    seg[i] = seg[i << 1] + seg[i << 1 | 1];
}

int query(int s, int e, int l, int r, int i = 1){
    propagate(s, e, i);
    if (r < s || e < l) return 0;
    if (l <= s && e <= r) return seg[i];
    const int m = (s + e) >> 1;
    return query(s, m, l, r, i << 1) + query(m + 1, e, l, r, i << 1 | 1);
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, m; cin >> n;
    for (int i = 1; i <= n; ++i){
        int p; cin >> p;
        if (i == 1) continue;
        children[p].push_back(i);
    }
    dfs(1, 1);
    build(1, n);

    cin >> m;
    for (int i = 0; i < m; ++i){
        int op, x; cin >> op >> x;
        if (op == 1)
            update(1, n, leftIdx[x] + 1, rightIdx[x] - 1, 1);
        else if (op == 2)
            update(1, n, leftIdx[x] + 1, rightIdx[x] - 1, -1);
        else
            cout << query(1, n, leftIdx[x] + 1, rightIdx[x] - 1) << '\n';
    }
}