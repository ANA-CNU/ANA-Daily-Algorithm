#include <iostream>
#include <queue>
#include <algorithm>
#define X first
#define Y second




using namespace std;



int dx[8] = {1,2,2,1,-1,-2,-2,-1};
int dy[8] = {2,1,-1,-2,2,1,-1,-2};

int dist[300][300];

int t, n, from_x, from_y, to_x, to_y;

queue<pair<int, int> > Q;


int main(){
    cin>>t;
    while(t--){
        cin>>n;

        for(int i=0; i<n; i++){
            fill(dist[i], dist[i] + n, -1);
        }

        cin>>from_x>>from_y;
        dist[from_x][from_y] = 0;
        Q.push({from_x,from_y});
        
        cin>>to_x>>to_y;
        
        while(!Q.empty()){
            pair<int,int> cur = Q.front(); Q.pop();


            for(int i=0; i<8; i++){
                int nx = cur.X + dx[i];
                int ny = cur.Y + dy[i];
                if(nx >= n || ny >= n || ny < 0 || nx < 0) continue;
                if(dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                Q.push({nx,ny});
            }


        }


        cout<<dist[to_x][to_y]<<'\n';



    }

}









