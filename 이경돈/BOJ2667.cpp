#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int graph[26][26];
int visited[25][25];
int di[4] = { 0,1,0,-1 }, dj[4] = { 1,0,-1,0 };
vector<int> vHome;

// 범위 검사
bool in_range(int x, int y) {
    return (0 <= x && x < n) && (0 <= y && y < n);
}

// 다음 노드 결정
pair<int, int> findNext() {
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n;j++)
            if (visited[i][j] == 0) // 방문 X인 노드를 pair로 리턴
                return { i,j };

    return { -1,-1 }; // 모두 방문했으면 {-1, -1} 리턴
}

void bfs(pair<int, int> start) {
    // 해당 위치에 집이 없으면 탈출 -> 재탐색
    if (graph[start.first][start.second] == 0)
        return;

    int i, j, ni, nj;
    queue<pair<int, int>> q;
    int cnt = 1; // 단지 개수 세는 cnt값 초기화

    // 탐색 시작 노드 세팅
    q.push(start);
    visited[start.first][start.second] = 1;
    while (!q.empty()) {
        i = q.front().first;
        j = q.front().second;
        q.pop();

        // 네 방향에 대해서 검사
        for (int d = 0; d < 4; d++) {
            ni = i + di[d];
            nj = j + dj[d];
            // 해당 위치가 범위 내, 집이 있으며, 방문하지 않았으면 큐에 추가하고 cnt 증가
            if (in_range(ni, nj) && graph[ni][nj] == 1 && visited[ni][nj] == 0) {
                q.push({ ni,nj });
                visited[ni][nj] = 1;
                cnt++;
            }
        }
    }

    vHome.push_back(cnt); // 벡터에 cnt값 추가
}

int main() {
    cin >> n;

    // 그래프 입력. 집이 없는 곳이면 visited 값을 -1로 세팅
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n;j++) {
            scanf("%1d", &graph[i][j]);
            if (graph[i][j] == 0)
                visited[i][j] = -1;
        }

    pair<int, int> nextNode = { 0,0 }; // 0,0 부터 탐색시작
    bool isNext = true;
    while (isNext) {
        bfs(nextNode); // nextNode부터 시작하는 bfs 탐색

        // 다음 탐색 시작할 노드를 찾고, 없으면 while문 종료
        nextNode = findNext();
        if (nextNode.first == -1)
            isNext = false;
    }

    sort(vHome.begin(), vHome.end()); // 오름차순 정렬

    cout << vHome.size() << "\n";
    for (int i = 0; i < vHome.size(); i++)
        cout << vHome[i] << "\n";
}

