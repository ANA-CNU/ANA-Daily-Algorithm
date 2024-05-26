#include <iostream>
#include <queue>

#define X first
#define Y second



int dx[6] = {2, 2, -2, -2, 0, 0};
int dy[6] = {-1, 1, -1, 1, -2, 2};

using namespace std;




int n;
int map[201][201];
int vis[201][201];



int main() {
    cin>>n;
    int r1, c1, r2, c2;
    cin>>r1>>c1>>r2>>c2;

    for (int i = 0; i < n; i++) {
        fill(map[i], map[i] + n, 0);
        fill(vis[i], vis[i] + n, 0);
    }

    queue<pair<int, int> > Q;

    Q.push(make_pair(r1, c1));

    vis[r1][c1] = 1;  

    while (!Q.empty()) {
        pair<int, int> cur = Q.front(); Q.pop();
        for (int i = 0; i < 6; i++) {
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if (nx >= n || nx < 0 || ny >= n || ny < 0) continue; 
            if (vis[nx][ny]) continue; 
            Q.push(make_pair(nx, ny));

            vis[nx][ny] = 1;
            map[nx][ny] = map[cur.X][cur.Y] + 1;


        }
    }



    if (vis[r2][c2]) {
        cout << map[r2][c2];
    } else {
        cout << -1;

    }




}
