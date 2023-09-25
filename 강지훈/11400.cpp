#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;
using edge = pair<int, int>;

int V, dcnt = 0, dfsn[100001] = {0};
vector<int> adj[100001];
stack<edge> st;
vector<edge> BCC;

int dfs(int pre, int cur) {
    int m = dfsn[cur] = ++dcnt;

    for (int next : adj[cur]) {
        if (pre == next) continue;

        if (dfsn[cur] > dfsn[next]) st.push(edge(cur, next));

        if (dfsn[next] > 0) m = min(m, dfsn[next]);
        else {
            int temp = dfs(cur, next);
            m = min(temp, m);

            if (temp >= dfsn[cur]) {
                if (st.top() == edge(cur, next)) {
                    BCC.push_back(edge(min(cur, next), max(cur, next)));
                } else {
                    while (st.top() != edge(cur, next)) {
                        st.pop();
                    }
                }
                st.pop();
            }
        }  
    }

    return m;
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    int E;
    cin >> V >> E;

    fill(adj, adj+V+1, vector<int>());

    while (E--) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(0, 1);
    sort(BCC.begin(), BCC.end());

    cout << BCC.size() << '\n';
    for (edge e : BCC) {
        cout << e.first << ' ' << e.second << '\n';
    }

    return 0;
}