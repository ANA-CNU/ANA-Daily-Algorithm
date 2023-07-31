#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int n, e;

int graph[101][101];
int visited[101];
int level[101];

int bfs(int start) {
    int node;
    queue<int> q;
    visited[start] = 1;
    q.push(start);
    level[start] = 0;
    while (!q.empty()) {
        node = q.front();
        q.pop();
        for (int i = 1; i <= n; i++)
            if (i != node)
                if (graph[node][i] == 1 && visited[i] == 0) {
                    q.push(i);
                    visited[i] = 1;
                    level[i] = level[node] + 1;
                }
    }

    int sum = 0;
    for (int i = 1; i <= n; i++)
        sum += level[i];

    return sum;
}

int main() {
    cin >> n >> e;
    
    int a, b;
    while (e-- > 0) {
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    int least = 9999999;
    int idx;
    int ans;
    for (int k = 1; k <= n; k++) {
        memset(visited, 0, sizeof(visited));
        memset(level, 0, sizeof(level));
        ans = bfs(k);
        if (ans < least) {
            least = ans;
            idx = k;
        }
    }

    cout << idx;
}

