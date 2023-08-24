#include <iostream>
#include <queue>
#include <algorithm>
#define X first
#define Y second

using namespace std;


int box[1001][1001];
int dis[1001][1001] = {0};
bool vis[1001][1001] = {0};
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};



int m,n;

queue<pair<int ,int> > Q;

void bfs(){
    while(!Q.empty()){
        pair<int,int> cur = Q.front(); Q.pop();
        for(int i=0; i<4; i++){
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if(nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if(dis[nx][ny] >=1) continue;
            if(box[nx][ny] == 0 && vis[nx][ny] == 0){
                vis[nx][ny] = 1;
                dis[nx][ny] = dis[cur.X][cur.Y] + 1;
                Q.push({nx,ny});
            }
        }
    }

}



int main(){
    cin>>m>>n;

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>box[i][j];
            if(box[i][j] == 1){
                Q.push({i,j});
            }
            else if(box[i][j] == -1){
                dis[i][j] = -1;
            }
            else{
                dis[i][j] = -2;
            }
        }
    }


    bfs();
    int max_days = 0;

    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(dis[i][j] == -2){
                cout<<-1;
                return 0;
            }
            max_days = max(max_days, dis[i][j]);
        }
    }

    cout<<max_days;


}