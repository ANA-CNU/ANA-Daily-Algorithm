#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sz = 75005;
// constexpr int sz = 100, sgsz = 1 << (33 - __builtin_clz(sz));

typedef pair<int, int> island;
island islands[sz];
int xTmp[sz], yTmp[sz];

struct fenwick
{
    int tree[sz], n;
    fenwick(int n) : n(n) { memset(tree, 0, sizeof(tree)); }
    void add(int i){ while (i < n) tree[i]++, i += i & -i; }
    int sum(int i){ int ret = 0; while (i > 0) ret += tree[i], i -= i & -i; return ret; }
    int query(int l, int r){ return sum(r) - sum(l - 1); }
};


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        for (int i = 1; i <= n; ++i) cin >> islands[i].first >> islands[i].second, xTmp[i] = islands[i].first, yTmp[i] = islands[i].second;
        // 좌표 압축
        sort(xTmp + 1, xTmp + n + 1); sort(yTmp + 1, yTmp + n + 1);
        for (int i = 1; i <= n; ++i) {
            islands[i].first = lower_bound(xTmp + 1, xTmp + n + 1, islands[i].first) - xTmp;
            islands[i].second = lower_bound(yTmp + 1, yTmp + n + 1, islands[i].second) - yTmp;
        }
        // 스위핑
        sort(islands + 1, islands + n + 1, [&](island &a, island &b) {
            return a.first == b.first ? a.second > b.second : a.first < b.first;
        });

        ll ans = 0;
        fenwick tree(n + 2);
        for (int i = 1; i <= n; ++i) {
            int x = islands[i].first, y = islands[i].second;
            ans += tree.query(y, n + 1);
            tree.add(y);
        }

        cout << ans << '\n';
    }
}