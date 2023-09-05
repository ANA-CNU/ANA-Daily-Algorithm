#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

#define INF 100000

using namespace std;
using point = pair<int, int>;
using point3 = pair<int, point>;

int dist[2][301][301];
bool cycle[2][301][301];
int N, M, K, T;
queue<point3> q;
int dx[] = {1, 2, 2, 1, -1, -2, -2, -1}, dy[] = {2, 1, -1, -2, -2, -1, 1, 2};

bool isIn(int x, int y) {
    return 0 < x && x < N+1 && 0 < y && y < N+1 ? 1 : 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> K >> T;
    for (int i = 0; i < 2; i++) {
        for (int j = 1; j < N+1; j++) {
            fill(dist[i][j]+1, dist[i][j]+N+1, INF);
            fill(cycle[i][j]+1, cycle[i][j]+N+1, 0);
        }
    }

    while(M--) {
        int x, y; cin >> x >> y;
        q.push(point3(0, point(x, y)));
        dist[0][y][x] = 0;
    }

    while (!q.empty()) {
        point3 cur = q.front();
        q.pop();
        int x = cur.second.first, y = cur.second.second, z = cur.first;

        for (int i = 0; i < 8; i++) {
            int nx = x+dx[i], ny = y+dy[i], nz = (z+1)%2;
            if (!isIn(nx, ny)) continue;

            if (dist[nz][ny][nx] == INF) {
                dist[nz][ny][nx] = dist[z][y][x]+1;
                if (dist[nz][ny][nx] < T) q.push(point3(nz, point(nx,ny)));
            } else if (!cycle[nz][ny][nx]) {
                cycle[nz][ny][nx] = 1;
                dist[nz][ny][nx] = dist[z][y][x]+1;
                if (dist[nz][ny][nx] < T) q.push(point3(nz, point(nx,ny)));
            }
        }
    }

    bool flag = true;
    while (K--) {
        int x, y; cin >> x >> y;
        if (cycle[T%2][y][x] || dist[T%2][y][x] == T) {
            flag = false;
            break;
        } 
    }

    cout << (flag ? "NO" : "YES");

    return 0;
}