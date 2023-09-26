#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <set>

using namespace std;
using edge = pair<int, int>;

int V, E, dcnt = 0, dfsn[201] = {0};
vector<int> adj[201];
stack<edge> st;
int BCC[201] = {0};
bool cycle_flag;

int dfs(int pre, int cur) {
    int m = dfsn[cur] = ++dcnt;

    for (int next : adj[cur]) {
        if (pre == next) continue;

        if (dfsn[cur] > dfsn[next]) st.push(edge(cur, next));

        if (dfsn[next] > 0) m = min(m, dfsn[next]);
        else {
            int temp = dfs(cur, next);
            m = min(m, temp);
            set<int> tempBCC;
            int edgecount = 1;

            if (dfsn[cur] <= temp) {
                while (st.top() != edge(cur, next)) {
                    ++edgecount;
                    tempBCC.insert(st.top().first);
                    tempBCC.insert(st.top().second);
                    st.pop();
                }
                tempBCC.insert(st.top().first);
                tempBCC.insert(st.top().second);
                st.pop();

                if (edgecount == 1) continue;

                if (tempBCC.size() != edgecount) {
                    cycle_flag = 0;
                }

                for (int v : tempBCC) {
                    ++BCC[v];
                }
            }
        }
    }

    return m;
}
 
int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    
    cin >> V >> E;

    fill(adj, adj+201, vector<int>());

    while (E--) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    int ans = 0;
    for (int i = 1; i < V+1; i++) {
        if (dfsn[i] == 0) {
            fill(BCC, BCC+201, 0);
            cycle_flag = 1;

            int temp = dfs(0, i);

            if (temp) {
                bool flag = 1;
                for (int i = 1; i < V+1; i++) {
                    if (BCC[i] > 1) {
                        flag = 0;
                        break;
                    }
                }
                if (flag && cycle_flag) ++ans;
            }
        }
    }

    cout << ans;
        
    return 0;
}