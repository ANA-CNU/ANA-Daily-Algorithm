#include <iostream>
#include <queue>
#include <string>
#include <vector>
using namespace std;
vector<vector<int>> v;
vector<vector<int>> visited;
int X[]={1,-1,0,0};
int Y[]={0,0,1,-1};
int bfs(int n,int m){
    queue<pair<int,int>> queue;
    visited[0][0] = 1;
    queue.emplace(0,0);
    while (!queue.empty()){
        int x=queue.front().first;
        int y=queue.front().second;
        queue.pop();
        for(int i=0;i<4;i++){
            int nx=x+X[i];
            int ny=y+Y[i];
            if(ny>=0&&ny<v.size()&&nx>=0&&nx<v[0].size()&&visited[ny][nx]==0&&v[ny][nx]==1){
                visited[ny][nx]=visited[y][x]+1;
                queue.emplace(nx,ny);
            }
        }
    }
    return visited[n-1][m-1];
}
int main(){
    int n,m;
    cin>>n>>m;
    v.resize(n);
    visited.resize(n);
    for(int i=0;i<n;i++){
        v[i].resize(m);
        visited[i].resize(m);
        visited[i].assign(m,0);
        string s;
        cin>>s;
        for(int j=0;j<m;j++){
            v[i][j]=s[j]-'0';
        }
    }
    cout<<bfs(n,m);
}
