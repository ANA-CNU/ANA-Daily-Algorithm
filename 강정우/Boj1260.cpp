#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;
vector<vector<int>> graph;
vector<int> visited;
int dfs(int v){
    stack<int> s;
    s.push(v);
    while(!s.empty()){
        int t=s.top();
        s.pop();
        if(visited[t-1]==0){
            visited[t-1]=1;
            cout<<t<<" ";
            for(int i=0;i<graph[t-1].size();i++){
                s.push(graph[t-1][i]);
            }
        }
    }
    cout<<"\n";
    return 0;
}
int bfs(int v){
    queue<int> q;
    q.push(v);
    while(!q.empty()){
        int t=q.front();
        q.pop();
        if(visited[t-1]==0){
            visited[t-1]=1;
            cout<<t<<" ";
            for(int i=0;i<graph[t-1].size();i++){
                q.push(graph[t-1][i]);
            }
        }
    }
    return 0;
}
bool compare(int a, int b){
    return a>b;
}
int main(){
    int n,m,v;
    cin>>n>>m>>v;
    visited.resize(n);
    graph.resize(n);
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        graph[a-1].push_back(b);
        graph[b-1].push_back(a);
    }
    for(int i=0;i<n;i++){
        sort(graph[i].begin(),graph[i].end(),compare);
    }
    dfs(v);
    visited.clear();
    visited.resize(n);
    for(int i=0;i<n;i++){
        sort(graph[i].begin(),graph[i].end());
    }
    bfs(v);
    return 0;
}
