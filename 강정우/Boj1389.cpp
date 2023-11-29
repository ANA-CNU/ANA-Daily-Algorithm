#include <iostream>
#include <queue>
#include <vector>
using namespace std;
vector<vector<int>> v;
vector<int> visited;
int bfs(int start,int end){
    queue<pair<int,int>> q;
    q.push({start,0});
    visited[start]=1;
    while(!q.empty()){
        int x=q.front().first;
        int y=q.front().second;
        q.pop();
        if(x==end) return y;
        for(int i=0;i<v[x].size();i++){
            if(visited[v[x][i]]==0){
                visited[v[x][i]]=1;
                q.push({v[x][i],y+1});
            }
        }
    }
    return 0;
}
int main(){
    int n,m;
    int result=0;
    int min=100000;
    cin>>n>>m;
    v.resize(n+1);
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for(int i=1;i<=n;i++){
        int k=0;
        for(int j=1;j<=n;j++){
            visited.resize(n+1);
            visited.assign(n+1,0);
            k+=bfs(i,j);
        }
        if(k<min){
            min=k;
            result=i;
        }
    }
    cout<<result;
    return 0;
}
