#include <iostream>
#include <algorithm>
#include <queue>
#include <stack>
#include <set>
 
using namespace std;
using edge = pair<int, int>;

int dcnt = 0, dfsn[10001];
stack<edge> st;
vector<vector<edge>> BCC;
vector<int> adj[10001];
int bcnt[10001]; 
int V, E;

int dfs(int pre, int cur) {
    int m = dfsn[cur] = dcnt++;

    for (int next : adj[cur]) {
        if (next == pre) continue;

        // 한 번도 가지 않았을 때와 역방향 간선만 체크 (중복 방문 no)
        if (dfsn[cur] > dfsn[next]) st.push(edge(cur, next));

        // 역방향
        if (dfsn[next] > -1) m = min(m, dfsn[next]);
        // 정방향
        else {
            int temp = dfs(cur, next);
            m = min(m, temp);

            // temp == dfsn[cur]인 경우는 사이클에서, temp > dfsn[cur]인 경우는 직선에서 온 것.
            if (temp >= dfsn[cur]) {
                vector<edge> tempBCC;
                while (edge(cur, next) != st.top()) {
                    tempBCC.push_back(st.top());
                    st.pop();
                }
                tempBCC.push_back(st.top());
                st.pop();
                BCC.push_back(tempBCC);
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

    fill(adj, adj+V+1, vector<int>());
    fill(dfsn, dfsn+V+1, -1);
    fill(bcnt, bcnt+V+1, 0);

    while (E-- > 0) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 1; i < V+1; i++) {
        if (dfsn[i] == -1) {
            dfs(0, i);
        }
    }

    for (int i = 0; i < BCC.size(); i++) {
        set<int> seet;
        for (edge e : BCC[i]) {
            seet.insert(e.first);
            seet.insert(e.second);
        }

        for (int n : seet) ++bcnt[n];
    }

    vector<int> ansv;
    int ansn = 0;

    for (int i = 1; i < V+1; i++) {
        if (bcnt[i] > 1) {
            ++ansn;
            ansv.push_back(i);
        }
    }

    sort(ansv.begin(), ansv.end());

    cout << ansn << '\n';
    for (int n : ansv) cout << n << ' ';

    return 0;
}