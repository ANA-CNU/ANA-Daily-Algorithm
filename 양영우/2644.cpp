#include <iostream>
#include <queue>

using namespace std;

queue<int> Q;
int map[101][101] = {0};
bool vis[101] = {false};
int n;
    
int a,b;

int x,y;

int m;

int kinship[101] = {0};



void BFS(int r){
    Q.push(r);
    vis[r] = true;

    while(!Q.empty()){
        r = Q.front();
        Q.pop();
        for(int k=1; k<= n; k++){
            if(map[r][k] == 1 && vis[k] == 0){
                Q.push(k);
                vis[k] = true;
                kinship[k] = kinship[r] + 1;
            }
        }


    }

    
    


}


int main(){
    cin>>n;
    cin>>a>>b;
    cin>>m;

    for(int i=0; i<m; i++){
        cin>>x>>y;
        map[x][y] = 1;
        map[y][x] = 1;
    }

    BFS(a);

    if(kinship[b] == 0){
        cout<<-1;
    }
    else{
        cout<<kinship[b];
    }
    






}