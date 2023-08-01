#include <iostream>
#include <queue>
using namespace std;

int m, n;
int graph[101][101];
int visited[101][101];
queue<pair<int, int>> q;

bool in_range(int x, int y) {
    return (0 <= x && x < n) && (0 <= y && y < m);
}

int bfs() {
    int di[4] = { 0,1,0,-1 }, dj[4] = { 1,0,-1,0 };
    int i, j , ni, nj;
    while (!q.empty()) {
        i = q.front().first;
        j = q.front().second;
        q.pop();
        for (int d = 0; d < 4; d++) {
            ni = i + di[d];
            nj = j + dj[d];
            if (in_range(ni, nj) && visited[ni][nj] == 0 && graph[ni][nj] == 0) {
                q.push({ ni,nj });
                visited[ni][nj] = 1;
                graph[ni][nj] = graph[i][j] + 1;
            }
        }
    }

    int mday = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            if (graph[i][j] == 0)
                return -1;
            if (mday < graph[i][j])
                mday = graph[i][j];
        }

    return mday-1;  
}

int main() {
    cin >> m >> n;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            cin >> graph[i][j];
            if (graph[i][j] == 1) {
                q.push({ i,j });
                visited[i][j] = 1;
            }
        }

    cout << bfs();
}