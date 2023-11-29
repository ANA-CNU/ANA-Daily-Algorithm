#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int x;
    int y;
    int cnt;
}st;
int n,m;
char arr[51][51];
int answer = 0;
void bfs(st start) {
    queue<st> q;
    int check[51][51];
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    for(int i=0; i<n; i++) for(int j=0; j<m; j++) check[i][j] = 0;

    q.push(start);
    check[start.x][start.y] = 1;

    while(!q.empty()) {
        st k = q.front();
        q.pop();
        for(int i=0; i<4; i++) {
            int x = k.x + dx[i];
            int y = k.y + dy[i];
            if(x < 0 || x >= n || y < 0 || y >= m || check[x][y] || arr[x][y] == 'W') continue;
            else {
                q.push({x, y, k.cnt+1});
                check[x][y] = 1;
                answer = max(answer, k.cnt + 1);
            }
        }
    }
}
int main()
{
    scanf("%d %d ",&n,&m);
    for(int i=0; i<n; i++) {
        scanf("%s",arr[i]);
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(arr[i][j] == 'L') bfs({i, j, 0});
        }
    }
    printf("%d",answer);
    return 0;
}
