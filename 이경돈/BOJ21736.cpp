#include <iostream>
#include <queue>
using namespace std;

char uni[600][600];
int visited[600][600];
int di[4] = { 0,1,0,-1 }, dj[4] = { 1,0,-1,0 };

bool in_range(int x, int y, int n, int m) {
    return (0 <= x && x < n) && (0 <= y && y < m);
}

int main() {
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m;
    int x, y;
    queue<pair<int, int>> q;
    cin >> n >> m;
    // 지도 입력
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++) {
            cin >> uni[i][j];
            if (uni[i][j] == 'I') { // 시작 위치 I 는 x, y에 저장
                x = i;
                y = j;
            }
        }

    // 시작 위치부터 방문
    q.push({ x,y });
    visited[x][y] = 1;
    
    int i, j, ni, nj;
    int cnt = 0;

    // 더이상 갈수 없을 때까지 탐색 (BFS)
    while (!q.empty()) {
        i = q.front().first;
        j = q.front().second;
        q.pop();
        if (uni[i][j] == 'P') cnt++; // 현재 방문한 위치가 P이면 카운팅
        
        for (int d = 0; d < 4; d++) { // 동 남 서 북 네 방향 검사
            ni = i + di[d];
            nj = j + dj[d];
            // 방문 가능하면 큐에 삽입하고 방문 표시
            if (uni[ni][nj] != 'X' && in_range(ni, nj, n, m) && visited[ni][nj] != 1) {
                q.push({ ni, nj });
                visited[ni][nj] = 1;
            }
        }
    }

    if (!cnt)
        cout << "TT"; // 0이면 TT 출력
    else
        cout << cnt;
}
