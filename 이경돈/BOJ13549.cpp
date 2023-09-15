#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int graph[100001];
int steps[1000001];
int visited[100001];
int n, k;

bool in_range(int x) {
    return x >= 0 && x <= 100000;
}

int bfs(int start) {
    //memset(steps, -1, sizeof(steps));
    queue<int> q;

    steps[start] = 0;
    int i;
    int ni[3];
    q.push(start);

    while (!q.empty()) {
        i = q.front();
        if (i == k) // k에 도착하면 탈출
            break;
        q.pop();

        // 세 가지 경우의 수 고려
        ni[0] = i + 1;
        ni[1] = i - 1;
        ni[2] = 2 * i;

        for (int d = 2; d >= 0; d--) {
            if (in_range(ni[d]) && visited[ni[d]] == 0) { // 범위 O, 방문 X이면
                visited[ni[d]] = 1;
                q.push(ni[d]);
                if (d == 2)
                    steps[ni[d]] = steps[i];
                else
                    steps[ni[d]] = steps[i] + 1;
            }
        }
    }

    return steps[k]; // k까지 가는데 걸린 시간 반환
}

int main() {
    cin >> n >> k;

    cout << bfs(n);
}