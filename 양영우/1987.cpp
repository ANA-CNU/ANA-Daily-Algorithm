#include <iostream>
#include <queue>
#define X first
#define Y second
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int cnt;
int max_cnt = 0;


using namespace std;

char map[21][21];

int map_count[21][21] = {0};

int isAlpha[26]; // A는 0





int r,c;



void DFS(int a, int b, int cnt){
    for(int i=0; i<4; i++){
        int nx = a +dx[i];
        int ny = b + dy[i];
        if(nx > r || nx < 1 || ny > c || ny < 1) continue;
        if(isAlpha[int(map[nx][ny] - 65)] == 1) continue;
        isAlpha[int(map[nx][ny] - 65)] = 1;
        DFS(nx,ny, cnt+1);
        isAlpha[int(map[nx][ny] - 65)] = 0;

    }
    max_cnt = max(max_cnt, cnt);

}






int main(){
    cin>>r>>c;

    for(int i=1; i<=r; i++){
        for(int j=1; j<=c; j++){
            cin>>map[i][j];
        }
    }

    isAlpha[int(map[1][1] - 65)] = 1;

    DFS(1,1,1);



    cout<<max_cnt;


}







