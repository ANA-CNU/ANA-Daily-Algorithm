#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define SOURCE 0
#define SINK 401
#define INF 500

using namespace std;

int N, F, D, V;
vector<int> adj[402];
int c[402][402], f[402][402];
int check[402], level[402];

int pairCow(int n) {
    return N + n;
}

int Food(int n) {
    return 2 * N + n;
}

int Drink(int n) {
    return 2 * N + F + n;
}

void setGraph() {
    for (int i = 0; i < 402; i++) {
        for (int j = 0; j < 402; j++) {
            f[i][j] = 0;
            c[i][j] = 0;
        }
    }

    for (int i = 1; i < N + 1; i++) {
        int j = pairCow(i);
        adj[i].push_back(j);
        adj[j].push_back(i);
        c[i][j] = 1;
    }

    for (int i = 1; i < F + 1; i++) {
        adj[SOURCE].push_back(Food(i));
        adj[Food(i)].push_back(SOURCE);
        c[SOURCE][Food(i)] = 1;
    }

    for (int i = 1; i < D + 1; i++) {
        adj[Drink(i)].push_back(SINK);
        adj[SINK].push_back(Drink(i));
        c[Drink(i)][SINK] = 1;
    }
}

void setLevel() {
    for (int i = 0; i < 402; i++) {
        level[i] = -1;
    }
}

void setCheck() {
    for (int i = 0; i < 402; i++) {
        check[i] = 0;
    }
}

bool bfs() {
    setLevel();

    queue<int> q;
    q.push(SOURCE);
    level[SOURCE] = 0;
    
    while (!q.empty()) {
        int cur = q.front();
        q.pop();

        for (int next : adj[cur]) {
            if (level[next] != -1 || c[cur][next] == f[cur][next]) continue;

            level[next] = level[cur] + 1;
            q.push(next);
        }
    }

    if (level[SINK] == -1) return false;
    else return true;
}

int dfs(int cur, int flow) {
    if (cur == SINK) return flow;

    int size = adj[cur].size();

    for (int i = 0; i < size; i++) {
        int next = adj[cur][i];
        int w = c[cur][next] - f[cur][next];

        if (level[next] != level[cur] + 1 || w == 0) continue;

        int temp = dfs(next, min(flow, w));
        if (temp > 0) {
            f[cur][next] += temp;
            f[next][cur] -= temp;
            return temp;
        }
    }

    return 0;
}

int Dinic() {
    int ans = 0;

    while (bfs()) {
        setCheck();
        int flow = 0;

        while ((flow = dfs(SOURCE, INF))) {
            ans += flow;
        }
    }

    return ans;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> N >> F >> D;
    V = 2 * N + F + D + 1;

    setGraph();
    
    for (int i = 1; i < N + 1; i++) {
        int f, d; cin >> f >> d;

        while (f--) {
            int j; cin >> j;
            int u = Food(j);
            int v = i;

            adj[u].push_back(v);
            adj[v].push_back(u);
            c[u][v] = 1;
        }

        while (d--) {
            int j; cin >> j;
            int u = pairCow(i);
            int v = Drink(j);

            adj[u].push_back(v);
            adj[v].push_back(u);
            c[u][v] = 1;
        }
    }

    cout << Dinic();
    
    return 0;
}