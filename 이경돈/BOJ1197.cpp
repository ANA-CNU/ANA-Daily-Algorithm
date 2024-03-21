#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int v, e;

vector<pair<int, int>> graph[10001];
bool visit[10001];

int prim(int start) {
    priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    int sum = 0;

    for (int i = 0; i < graph[start].size(); i++) {
        int next = graph[start][i].first;
        int dist = graph[start][i].second;

        pq.push({ dist, next });
    }

    visit[start] = true;
    while (!pq.empty()) {
        int dist = pq.top().first;
        int cur = pq.top().second;
        pq.pop();

        if (!visit[cur]) {
            visit[cur] = true;

            sum += dist;

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur][i].first;
                int nDist = graph[cur][i].second;

                if (!visit[next])
                    pq.push({ nDist, next });
            }
        }
    }

    return sum;
}

int main() {
    int a, b, w;
    int mind;

    cin >> v >> e;

    for (int i = 0; i < e; i++) {
        cin >> a >> b >> w;

        graph[a].push_back({ b, w });
        graph[b].push_back({ a, w });
    }

    cout << prim(1);
}