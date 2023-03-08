#include <iostream>
#include <vector>

using namespace std;

int N, lg2;
vector<int> adj[100001];
int level[100001];
int table[17][100001];

void BtR() {
    for (int i = 0; i < 100001; i++) {
        level[i] = -1;
    }

    table[0][1] = -1;
    level[1] = 0;
}

int log2() {
    int cur = 1;
    for (int i = 0; i < 17; i++) {
        if (cur > N) {
            return i - 1;
        }

        cur <<= 1;
    }

    return 16;
}

void dfs(int cur) {
    for (int next : adj[cur]) {
        if (level[next] != -1) continue;

        level[next] = level[cur] + 1;
        table[0][next] = cur;
        dfs(next);
    }
}

void makeTable() {
    for (int i = 1; i < lg2 + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            if (table[i - 1][j] == -1) {
                table[i][j] = -1;
            } else {
                table[i][j] = table[i - 1][table[i - 1][j]];
            }
        }
    }
}

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int LCA(int u, int v) {
    if (level[u] > level[v]) swap(u, v);

    if (level[u] != level[v]) {
        for (int i = lg2; i > -1; i--) {
            if (table[i][v] != -1 && (level[u] <= level[table[i][v]])) {
                v = table[i][v];
            }
        }   
    }

    if (u == v) return u;

    for (int i = lg2; i > -1; i--) {
        if (table[i][u] != -1 && (table[i][u] != table[i][v])) {
            u = table[i][u]; v = table[i][v];
        }
    }

    return table[0][u] == table[0][v] ? table[0][u] : 999999;
}

int solve(int r, int u, int v) {
    int ur = LCA(u, r), vr = LCA(v, r), uv = LCA(u, v);

    if (ur == vr) return uv;
    else if (ur == u && vr == uv) return u;
    else if (vr == v && ur == uv) return v;
    else if (ur == r && vr != r) return r;
    else if (ur != r && vr == r) return r;
    else if (ur == uv) return vr;
    else if (vr == uv) return ur;
    else {
        while (1) {

        }
    }

    return 99999999;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    BtR();

    cin >> N;
    lg2 = log2();

    for (int i = 1; i < N; i++) {
        int u, v; cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int next : adj[1]) {
        level[next] = 1;
        table[0][next] = 1;
        dfs(next);
    }
    makeTable();

    int M; cin >> M;
    while (M--) {
        int r, u, v; cin >> r >> u >> v;

        cout << solve(r, u, v) << '\n';
    }

    return 0;
}