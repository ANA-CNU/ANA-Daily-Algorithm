#include <iostream>
#include <algorithm>
#include <queue>

#define INF 101

using namespace std;

int N, M;
vector<int> adj[402];
int c[402][402], f[402][402];

void BtR() {
    for (int i = 0; i < 402; i++) {
        for (int j = 0; j < 402; j++) {
            c[i][j] = 0;
            f[i][j] = 0;
        }
    }
}

int Ed() {
    const int sink = 2 * N + 2 * M + 1;
    int ans = 0;
    queue<int> q;

    while (1) {
        int prev[402];
        for (int i = 0; i < 402; i++) {
            prev[i] = -1;
        }

        while (!q.empty()) q.pop();
        q.push(0);

        while (!q.empty()) {
            int cur = q.front();
            q.pop();

            for (int next : adj[cur]) {
                if (prev[next] != -1) continue;

                if (c[cur][next] > f[cur][next]) {
                    prev[next] = cur;
                    if (next == sink) break;

                    q.push(next);
                }

            }
        }

        if (prev[sink] == -1) break;

        int flow = INF;
        for (int i = sink; i != 0; i = prev[i]) {
            flow = min(flow, c[prev[i]][i] - f[prev[i]][i]);
        }

        for (int i = sink; i != 0; i = prev[i]) {
            f[prev[i]][i] += flow;
            f[i][prev[i]] -= flow;
        }

        ans += flow;
    }

    return ans;
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    BtR();

    cin >> N >> M;
    
    for (int i = 1; i < N + 1; i++) {
        int w; cin >> w;

        adj[0].push_back(i + N + M);
        adj[i + N + M].push_back(0);

        adj[i + N + M].push_back(i);
        adj[i].push_back(i + N + M);

        c[0][i + N + M] = INF;
        c[i + N + M][i] = w;
    }

    for (int i = N + 1; i < N + M + 1; i++) {
        int w; cin >> w;

        adj[i].push_back(i + N + M);
        adj[i + N + M].push_back(i);

        adj[i + N + M].push_back(2 * N + 2 * M + 1);
        adj[2 * N + 2 * M + 1].push_back(i + N + M);
        
        c[i][i + N + M] = w;
        c[i + N + M][2 * N + 2 * M + 1] = INF;
    }

    for (int i = N + 1; i < N + M + 1; i++) {
        for (int j = 1; j < N + 1; j++) {
            int w; cin >> w;
            adj[j].push_back(i);
            adj[i].push_back(j);
            c[j][i] = w;
        }
    }

    cout << Ed();

    return 0;
}