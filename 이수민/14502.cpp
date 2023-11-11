#include <bits/stdc++.h>
using namespace std;
int arr[9][9];
int answer = 0;
int n,m;
typedef struct {
    int x;
    int y;
}st;
void bfs() {
    queue<st> q;
    int arr_[9][9];
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            arr_[i][j] = arr[i][j];
            if(arr_[i][j] == 2) q.push({i, j});
        }
    }
    while(!q.empty()) {
        st s = q.front();
        q.pop();

        for(int i=0; i<4; i++) {
            int x = s.x + dx[i];
            int y = s.y + dy[i];

            if(x < 0 || x >= n || y < 0 || y >= m || arr_[x][y] != 0) continue;
            arr_[x][y] = 2;
            q.push({x, y});
        }
    }
    int cnt = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(arr_[i][j] == 0) cnt++;
        }
    }
    answer = answer < cnt ? cnt : answer;
}
void wall(int cnt) {
    if(cnt == 3) {
        bfs();
        return ;
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(arr[i][j] == 0) {
                arr[i][j] = 1;
                wall(cnt+1);
                arr[i][j] = 0;
            }
        }
    }
}
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            scanf("%d",&arr[i][j]);
        }
    }
    wall(0);
    printf("%d",answer);
    return 0;
}
