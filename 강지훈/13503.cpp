#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
#include <sstream>
 
using namespace std;

int N;
vector<int> adj[10001];
int B[10001];
bool visited[10001];

void BtR() {
    for (int i = 0; i < 10001; i++) {
        B[i] = -1;
    }
}

void setVisited() {
    for (int i = 0; i < 10001; i++) {
        visited[i] = false;
    }
}

bool dfs(int cur) {
    visited[cur] = true;

    for (int next : adj[cur]) {
        if (B[next] == -1 || !visited[B[next]] && dfs(B[next])) {
            B[next] = cur;
            return true;
        }
    }

    return false;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    BtR();
    
    cin >> N;
    int M; cin >> M;

    while (M--) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
    }

    int ans = N;

    for (int i = 1; i < N + 1; i++) {
        setVisited();
        if(dfs(i)) --ans;
    }

    cout << ans;
 
    return 0;
}