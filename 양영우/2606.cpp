#include <iostream>

using namespace std;


int n,m;
bool vis[101]; // 컴퓨터의 방문 여부
int a,b; // a와 b가 연결되어있다
int com[101][101];

int cnt = 0;

void BFS(int a){
    vis[a] = true;
    cnt ++;
    for(int i=1; i<=n; i++){
        if(vis[i] == false && com[a][i] == 1){
            BFS(i);
        }
    }
}


int main(){
    cin>>n>>m;
    for(int i=0; i<m; i++){
        cin>>a>>b;
        com[a][b] = 1;
        com[b][a] = 1;
    }

    BFS(1);


    cout<<cnt - 1;
}