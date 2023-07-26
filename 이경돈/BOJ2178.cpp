#include <iostream>
#include <queue>
#include <string>
using namespace std;

int n, m;
char a[101][101];
int visited[101][101];
int step[100][100];

// 범위 검사
bool in_range(int i, int j) {
    return (0 <= i && i < n) && (0 <= j && j <= m);
}

// bfs
void bfs(pair<int, int> start) {
    int i, j, ni, nj;
    int di[4] = { 0,1,0,-1 }, dj[4] = { 1,0,-1,0 };
    queue<pair<int, int>> q;

    // 방문 표시와 거리 기록
    visited[start.first][start.second] = 1;
    step[start.first][start.second] = 1;
    
    q.push(start);
    while (!q.empty()) {
        i = q.front().first;
        j = q.front().second;
        q.pop();

        // 네 방향 검사
        for (int d = 0; d < 4; d++) {
            ni = i + di[d];
            nj = j + dj[d];
            // 범위 내이고, 갈 수 있으며, 방문하지 않았으면
            if (in_range(ni, nj) && a[ni][nj] == '1' && visited[ni][nj] == 0) {
                q.push({ ni,nj });
                visited[ni][nj] = 1; // 방문 표시
                step[ni][nj] = step[i][j] + 1; // 현재노드 대비 다음 노드는 거리 1 증가
            }
        }
    }
}

int main() {
    cin >> n >> m;
    string buf;

    // 그래프 입력
    for (int i = 0; i < n; i++) {
        cin >> buf;
        for (int j = 0; j < m; j++)
            a[i][j] = buf[j];
    }

    // (0,0)에서 시작
    bfs({ 0,0 });

    // 출구의 거리수를 출력
    cout << step[n - 1][m - 1];
}