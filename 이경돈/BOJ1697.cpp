#include <iostream>
#include <queue>
using namespace std;

int graph[100001];
int steps[1000001];
int visited[100001];
int n, k;

bool in_range(int x) {
    return x >= 0 && x <= 100000;
}

int bfs(int start) {
    queue<int> q;
    steps[start] = 0;
    int i;
    int ni[3];
    q.push(start);

    while (!q.empty()) {
        i = q.front();
        if (i == k)
            break;
        q.pop();
        
        ni[0] = i + 1;
        ni[1] = i - 1;
        ni[2] = 2 * i;

        for (int d = 0; d < 3; d++) {
            if (in_range(ni[d]) && visited[ni[d]] == 0) {
                visited[ni[d]] = 1;
                q.push(ni[d]);
                steps[ni[d]] = steps[i]+1;
            }
        }
    }

    return steps[k];
}

int main() {
    cin >> n >> k;

    cout << bfs(n);
}