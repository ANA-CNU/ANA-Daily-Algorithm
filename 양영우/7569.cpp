#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int m, n, h;
int day = 0;

int dist[101][101][101];
int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};

queue<tuple<int, int, int>> Q;
int box[101][101][101];

int main() {
    cin >> n >> m >> h;

    for (int k = 0; k < h; k++) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cin >> box[i][j][k];
                if (box[i][j][k] == 1) {
                    Q.push({i, j, k});
                    dist[i][j][k] = 0;
                } else if (box[i][j][k] == -1) {
                    dist[i][j][k] = -1;
                } else {
                    dist[i][j][k] = 1000001;  
                }
            }
        }
    }

    while (!Q.empty()) {
        tuple<int, int, int> cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 6; dir++) {
            int nx = get<0>(cur) + dx[dir];
            int ny = get<1>(cur) + dy[dir];
            int nz = get<2>(cur) + dz[dir];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;
            if (box[nx][ny][nz] != -1 && dist[nx][ny][nz] > dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1) {
                dist[nx][ny][nz] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1;
                day = max(day, dist[nx][ny][nz]);
                Q.push({nx, ny, nz});
            }
        }
    }

    bool not_ripened = false;
    for (int k = 0; k < h; k++)
    {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j][k] == 0 && dist[i][j][k] == 1000001) { 
                    not_ripened = true;
                    break;
                }
            }
            if (not_ripened) break;
        }
        if (not_ripened) break;
    }

    if (not_ripened) {
        cout << "-1" << endl;
    } else {
        cout << day << endl;
    }

}