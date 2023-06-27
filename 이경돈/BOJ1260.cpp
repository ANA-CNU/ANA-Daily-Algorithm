#include <iostream>
#include <queue>
using namespace std;

int graph[1001][1001];
int visit[1001];

void dfs(int graph[][1001], int n, int startNode) {
    int i = 1;
    visit[startNode] = 1;

    cout << startNode << " ";

    for (i = 1; i <= n; i++)
        if (i != startNode)
            if (graph[startNode][i] != 0)
                if (visit[i] == 0)
                    dfs(graph, n, i);
}

void bfs(int graph[][1001], int n, int startNode) {
    queue<int> q;
    int i = 0;
    int node;
    
    visit[startNode] = 1;

    q.push(startNode);

    while (!q.empty()) {
        node = q.front();
        q.pop();
        cout << node << " ";
        for (i = 1; i <= n; i++)
            if (i != node)
                if (graph[node][i] != 0)
                    if (visit[i] == 0){
                        visit[i] = 1;
                        q.push(i);
                    }
    }
}

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m, v;
    cin >> n >> m >> v;

    int a, b;

    while (m-- > 0) {
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    dfs(graph, n, v);
    
    fill_n(visit, 1001, 0);
    cout << "\n";

    bfs(graph, n, v);
}