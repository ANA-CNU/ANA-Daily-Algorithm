#include <iostream>
#include <queue>
using namespace std;

int board[101];
int visited[101];
int steps[101];

// start 위치부터 bfs 탐색 시작
int bfs(int start) {
    queue<int> q;
    int ci, ni;

    visited[start] = 1;
    steps[start] = 0;
    q.push(start);

    while (!q.empty()) {
        ci = q.front();
        if (ci == 100)
            return steps[100]; // 100번 칸 도착했으면 주사위 횟수를 반환
        q.pop();

        // 현재 칸에서 1~6 더한 칸들로 이동할 수 있음 -> 다음칸에 대해 검사
        for (int d = 1; d <= 6; d++) {
            ni = ci + d; // ni = 다음 칸
            if (board[ni] != 0) // 사다리나 뱀이 있는 칸이면 목적지 칸으로 '다음칸(ni)'을 이동시킴
                ni = board[ni];
            if (visited[ni] == 0 && ni >= 0 && ni <= 100) { // 범위 및 방문 여부 검사
                visited[ni] = 1;
                steps[ni] = steps[ci] + 1; // 다음 칸으로 진행하는 경우, 주사위 횟수 갱신
                q.push(ni);
            }
        }
    }

    return -1;
}

int main() {
    int l, s;
    int frm, to;

    cin >> l >> s;

    for (int i = 0; i < l + s; i++) {
        cin >> frm >> to;
        board[frm] = to; // 사다리나 뱀의 목적지를 배열에 기록
    }

    cout << bfs(1); // 1부터 시작하는 bfs
}