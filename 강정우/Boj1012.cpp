#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int m,n,cnt;
vector<vector<int>> v;
vector<vector<int>> visited;
int dx[4] = {0, 0, -1, 1};
int dy[4] = {-1, 1, 0, 0};
void dp(int x,int y){
    if(visited[x][y]==1){
        return;
    }
    queue<pair<int,int>> q;
    q.push({x,y});
    visited[x][y] = 1;
    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx>=0 && ny>=0 && nx<m && ny<n && v[nx][ny]==1 && visited[nx][ny]==0){
                visited[nx][ny] = 1;
                q.push({nx,ny});
            }
        }
    }
    cnt++;
}
int main(){
    int t,k;
    cin>>t;
    for(int i=0;i<t;i++){
        cin>>m>>n>>k;
        m++;
        n++;
        cnt=0;
        int arr[k][2];
        visited.assign(m,vector<int>(n,0));
        v.assign(m,vector<int>(n,0));
        for(int j=0;j<k;j++){
            cin>>arr[j][0]>>arr[j][1];
            v[arr[j][0]][arr[j][1]]=1;
        }
        for(int j=0;j<k;j++){
            dp(arr[j][0],arr[j][1]);
        }
        cout<<cnt<<"\n";
    }
}
