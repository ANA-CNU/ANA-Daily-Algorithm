#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int m, n, h;
int graph[101][101][101];
int visited[101][101][101];
queue<tuple<int, int, int>> q;

// 범위 검사
bool in_range(int k, int x, int y) {
    return (0 <= x && x < n) && (0 <= y && y < m) && (0 <= k && k < h);
}

// BFS
int bfs() {
    int di[4] = { 0,1,0,-1 }, dj[4] = { 1,0,-1,0 };
    int dk[2] = { -1,1 };
    int i, j, k, ni, nj, nk;
    while (!q.empty()) {
        k = get<0>(q.front());
        i = get<1>(q.front());
        j = get<2>(q.front());
        q.pop();
        // 상하좌우 네 방향 검사
        for (int d = 0; d < 4; d++) {
            ni = i + di[d];
            nj = j + dj[d];
            // 범위 내이고, 방문 X이며, 익지 않은 토마토(0) 이면
            if (in_range(k, ni, nj) && visited[k][ni][nj] == 0 && graph[k][ni][nj] == 0) {
                q.push(make_tuple(k, ni, nj));
                visited[k][ni][nj] = 1;
                graph[k][ni][nj] = graph[k][i][j] + 1; // 그래프에 직접 걸린 날짜를 기록(1부터 시작)
            }
        }

        // 위 아래 판 검사
        for (int d = 0; d < 2; d++) {
            nk = k + dk[d];
            // 범위 내이고, 방문 X이며, 익지 않은 토마토(0) 이면
            if (in_range(nk, i, j) && visited[nk][i][j] == 0 && graph[nk][i][j] == 0) {
                q.push(make_tuple(nk, i, j));
                visited[nk][i][j] = 1;
                graph[nk][i][j] = graph[k][i][j] + 1; // 그래프에 직접 걸린 날짜를 기록(1부터 시작)
            }
        }
    }

    int mday = 0; // 날짜의 최댓값을 구함 -> 전부 익기까지 걸리는 날짜
    for (int k = 0; k < h; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (graph[k][i][j] == 0)
                    return -1; // 익지 못한 토마토가 있으면 -1 반환
                if (mday < graph[k][i][j])
                    mday = graph[k][i][j];
            }

    return mday - 1; // 1부터 시작했으므로, -1 해준 후 반환
}

int main() {
    cin >> m >> n >> h;

    for (int k = 0; k < h; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                cin >> graph[k][i][j];
                // 익은 토마토는 미리 큐에 추가+방문 표시
                if (graph[k][i][j] == 1) {
                    q.push(make_tuple(k, i, j));
                    visited[k][i][j] = 1;
                }
            }

    cout << bfs();
}