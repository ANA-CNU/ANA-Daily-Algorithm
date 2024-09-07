#include <bits/stdc++.h>

using namespace std;
typedef long long int ll;

constexpr int sz = 250005, sgsz = 1 << 19;
// constexpr int sz = 10, sgsz = 1 << 5;
constexpr ll inf = 1e18;

struct node
{
    // 거리, 노드 인덱스
    vector<pair<ll, int>> adj;
} *nodes[sgsz * 2 + sz];
// 1 ~ sgsz : arrival segment tree
// sgsz + 1 ~ 2 * sgsz : departure segment tree
// 2 * sgsz + 1 ~ 2 * sgsz + sz : dummy nodes

struct dijkstra_node
{
    ll d; int u;
    bool operator<(const dijkstra_node &o) const {
        return d > o.d;
    }
};

int loc[sz];
ll dists[sgsz * 2 + sz];

// arrival, departure
pair<node*, node*> build(int s, int e, int i = 1){
    if (s == e){
        // arrival
        nodes[i] = new node();
        loc[s] = i;
        // departure
        nodes[i + sgsz] = new node();
        nodes[i + sgsz]->adj.push_back({0, i});
        return {nodes[i], nodes[i + sgsz]};
    }
    const int m = (s + e) >> 1;
    auto left = build(s, m, i << 1);
    auto right = build(m + 1, e, i << 1 | 1);
    // arrival: 자식 -> 부모
    nodes[i] = new node();
    left.first->adj.push_back({0, i});
    right.first->adj.push_back({0, i});
    // departure: 부모 -> 자식
    nodes[i + sgsz] = new node();
    nodes[i + sgsz]->adj.push_back({0, (i << 1) + sgsz});
    nodes[i + sgsz]->adj.push_back({0, (i << 1 | 1) + sgsz});
    return {nodes[i], nodes[i + sgsz]};
}

void connect(int s, int e, int l, int r, pair<ll, int> t, bool isArrival, int i = 1){
    if (e < l || s > r) return;
    if (l <= s && e <= r){
        if (isArrival){
            nodes[i]->adj.push_back(t);
        } else {
            nodes[t.second]->adj.push_back({0, i + sgsz});
        }
        return;
    }
    const int m = (s + e) >> 1;
    connect(s, m, l, r, t, isArrival, i << 1);
    connect(m + 1, e, l, r, t, isArrival, i << 1 | 1);
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);

    int n, m, k; cin >> n >> m >> k;
    build(1, n);

    for (int i = 1; i <= m; ++i){
        int a, b, c, d, e; cin >> a >> b >> c >> d >> e;
        const int idx = 2 * sgsz + i;
        nodes[idx] = new node();
        connect(1, n, b, c, {a, idx}, true);
        connect(1, n, d, e, {a, idx}, false);
    }

    fill(dists, dists + sgsz * 2 + sz, inf);
    dists[loc[k]] = 0;
    priority_queue<dijkstra_node> pq;
    pq.push({0, loc[k]});
    while (!pq.empty()){
        auto curNode = pq.top(); pq.pop();
        auto& d = curNode.d; auto& u = curNode.u;
        for (auto& p : nodes[u]->adj){
            auto& w = p.first; auto& v = p.second;
            if (dists[v] > d + w){
                dists[v] = d + w;
                pq.push({d + w, v});
            }
        }
    }

    for (int i = 1; i <= n; ++i){
        if (dists[loc[i]] == inf) cout << "-1 ";
        else cout << dists[loc[i]] << ' ';
    }
    cout << '\n';
}