#include <iostream>
#include <algorithm>
#include <queue>
#include <stack>
#include <set>
 
using namespace std;
using edge = pair<int, int>;

int V, E, dcnt = 0, dfsn[100001];
vector<int> adj[100001];
stack<edge> st;
int BCC[100001];
bool flag = 1;

int dfs(int pre, int cur) {
    int m = dfsn[cur] = dcnt++;

    for (int next : adj[cur]) {
        if (pre == next) continue;

        if (dfsn[cur] > dfsn[next]) st.push(edge(cur, next));

        if (dfsn[next] != -1) m = min(m, dfsn[next]);
        else {
            int temp = dfs(cur, next);
            m = min(m, temp);

            if (temp >= dfsn[cur]) {
                vector<edge> tempBCC;
                while (st.top() != edge(cur, next)) {
                    tempBCC.push_back(st.top());
                    st.pop();
                }
                tempBCC.push_back(st.top());
                st.pop();

                if (tempBCC.size() == 1) continue;

                set<int> tempset;
                for (edge e : tempBCC) {
                    tempset.insert(e.first);
                    tempset.insert(e.second);
                }

                if (tempset.size() != tempBCC.size()) flag = 0;

                for (int n : tempset) {
                    ++BCC[n];
                }
            }
        }
    }

    return m;
}

string is_cactus() {
    if (!flag) return "Not cactus";
    for (int i = 1; i < V+1; i++) {
        if (BCC[i] > 1) return "Not cactus";
    }
    return "Cactus";
}

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);

    cin >> V >> E;

    fill(dfsn, dfsn+V+1, -1);
    fill(adj, adj+V+1, vector<int>());
    fill(BCC, BCC+V+1, 0);

    while (E--) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs(0, 1);

    cout << is_cactus();
    
    return 0;
}