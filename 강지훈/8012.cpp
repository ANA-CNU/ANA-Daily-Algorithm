#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, lg2, M;
vector<int> adj[30001];
int level[30001];
int parent[15][30001];

void BtR() {
    for (int j = 0; j < 30001; j++) {
        level[j] = -1;

        for (int i = 0; i < 15; i++) {
            parent[i][j] = -1;
        }
    }

    parent[0][1] = -1;
    level[1] = 0;
}

int log2(int n) {
    int cur = 1;
    
    for (int i = 0; i < 16; i++) {
        if (n - cur < 0) {
            return i - 1;
        }
        cur <<= 1;
    }

    return 15;
}

void dfs(int cur) {
    for (int next : adj[cur]) {
        if (level[next] != -1) continue;

        level[next] = level[cur] + 1;
        parent[0][next] = cur;
        dfs(next);
    }
}

void setTable() {
    for (int i = 1; i < lg2 + 1; i++) {
        for (int j = 1; j < 30001; j++) {
            if (parent[i - 1][j] == -1) {
                parent[i][j] = -1;
            } else {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }
}

void swap(int &u, int &v) {
    int temp = u;
    u = v;
    v = temp;
}

int LCA(int u, int v) {
    int lvsum = level[u] + level[v];

    if (level[u] != level[v]) {
        if (level[u] > level[v]) swap(u, v);

        for (int i = lg2; i > -1; i--) {
            if (parent[i][v] == -1) continue;

            if (level[parent[i][v]] >= level[u]) {
                v = parent[i][v];

                if (level[u] == level[v]) break;
            }
        }
    }

    if (u != v) {
        for (int i = lg2; i > -1; i--) {
            if (parent[i][u] == -1) continue;

            if (parent[i][u] != parent[i][v]) {
                u = parent[i][u]; v = parent[i][v];
            }
        }

        u = parent[0][u]; v = parent[0][v];
    }

    lvsum -= (level[u] + level[v]);

    return lvsum;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    BtR();

    cin >> N;
    lg2 = log2(N);

    for (int i = 1; i < N; i++) {
        int u, v; cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int next : adj[1]) {
        level[next] = 1;
        parent[0][next] = 1;

        dfs(next);
    }

    setTable();

    cin >> M;
    int cur = 1, ans = 0;

    while (M--) {
        int next; cin >> next;
        ans += LCA(cur, next);
        cur = next;
    }

    cout << ans;

    return 0;
}