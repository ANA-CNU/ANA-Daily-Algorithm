#include <iostream>

using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int m,n;
int map[501][501];
int dp[501][501];


int DFS(int a, int b){
    if(a == m-1 && b == n-1) return 1; 
    if(dp[a][b] != -1) return dp[a][b]; 

    dp[a][b] = 0; 

    for(int i=0; i<4; i++){
        int nx = a + dx[i];
        int ny = b + dy[i];
        if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] < map[a][b]){
            dp[a][b] += DFS(nx,ny);
        }
    }
    return dp[a][b];
}




int main(){
    cin>>m>>n;

    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            cin>>map[i][j];
            dp[i][j] = -1;
        }
    }

    cout<<DFS(0,0);









}

