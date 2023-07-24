#include <iostream>
using namespace std;

int visited[1001];
int graph[1001][1001];
int n;

int keepGoing() {
    for (int i = 1; i <= n; i++)
        if (visited[i] != 1)
            return i;
    
    return 0;
}

void DFS(int start) {
    visited[start] = 1;
    
    for (int i = 0; i <= n; i++)
        if (start != i)
            if (graph[start][i] != 0)
                if (visited[i] != 1)
                    DFS(i);
}

int main() {
    int e;
    cin >> n >> e;

    int a, b;
    while (e-- > 0) {
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    int cnt = 0;
    int start = 1;
    while (start) {
        DFS(start);

        cnt++;
        start = keepGoing();
    }

    cout << cnt;
}