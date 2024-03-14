#include <iostream>
#include <queue>
#include <vector>
#define X first
#define Y second



const int INF = 1e9;
using namespace std;

int map[126][126];

int d[126][126];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n;

int main() {
    int cnt = 1;

    while (true) {

        priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;

        cin >> n;

        if (n == 0) {
            break;
        }

        for (int i = 0; i < n; i++) {
            fill(d[i], d[i] + n, INF); 
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> map[i][j];
            }
        }

        pq.push(make_pair(0, 0));
        d[0][0] = map[0][0];



        while (!pq.empty()) {
            pair<int, int> cur = pq.top();pq.pop();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (d[nx][ny] > d[cur.X][cur.Y] + map[nx][ny]) {
                    d[nx][ny] = d[cur.X][cur.Y] + map[nx][ny];
                    pq.push(make_pair(nx, ny));
                }
            }
        }

        cout << "Problem " << cnt << ": " << d[n - 1][n - 1] << '\n';
        cnt++; 
    }
    return 0;
}
