#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;
using edge = pair<int, int>;

int N, M, dfsn[4445], dcnt=0;
vector<int> adj[4445];
stack<edge> edges;
int ans = 0;

int dfs(int cur, int pre) {
    int m = dfsn[cur] = ++dcnt;

    for (int next : adj[cur]) {
        if (next == pre) continue;

        if (dfsn[cur] > dfsn[next]) edges.push(edge(cur, next));

        if (dfsn[next] > 0) m = min(m, dfsn[next]);
        else {
            int temp = dfs(next, cur);
            m = min(m, temp);

            if (temp > dfsn[cur]) {
                edges.pop();
            } else if (temp == dfsn[cur]) {
                int tempans = 1;
                while (edges.top() != edge(cur, next)) {
                    edges.pop();
                    ++tempans;
                }
                edges.pop();

                ans = max(ans, tempans);
            }
        }
    }

    return m;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int T; cin >> T;
    while (T--) {
        cin >> N >> M;
        fill(adj, adj+N+1, vector<int>());
        fill(dfsn, dfsn+N+1, 0);
        ans = 0;

        while (M--) {
            int u, v; cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        for (int i = 1; i < N+1; i++) {
            if (dfsn[i] == 0) {
                dfs(i, 0);
            }
        }

        cout << ans << '\n';
    }
        
    return 0;
}