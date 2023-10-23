#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int dx[6]={0,0,0,0,1,-1};
int dy[6]={0,0,1,-1,0,0};
int dz[6]={1,-1,0,0,0,0};
int m,n,h;
int result=0;
queue<pair<pair<int,int>,pair<int,int>>> q;
vector<vector<vector<int>>> arr;
void dp(){
    while(!q.empty()){
        int z=q.front().first.first;
        int y=q.front().first.second;
        int x=q.front().second.first;
        int day=q.front().second.second;
        q.pop();
        for(int i=0;i<6;i++){
            int nz=z+dz[i];
            int ny=y+dy[i];
            int nx=x+dx[i];
            int tmp_day=day+1;
            if(nz>=0&&nz<h&&ny>=0&&ny<n&&nx>=0&&nx<m){
                if(arr[nz][ny][nx]==0){
                    arr[nz][ny][nx]=1;
                    q.push({{nz,ny},{nx,tmp_day}});
                    result=max(result,tmp_day);
                }
            }
        }
    }

}
int main(){
    cin>>m>>n>>h;
    arr.resize(h,vector<vector<int>>(n,vector<int>(m)));
    for(int i=0;i<h;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                cin>>arr[i][j][k];
            }
        }
    }
    for(int i=0;i<h;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                if(arr[i][j][k]==1){
                    q.push({{i,j},{k,0}});
                }
            }
        }
    }
    dp();
    for(int i=0;i<h;i++){
        for(int j=0;j<n;j++){
            for(int k=0;k<m;k++){
                if(arr[i][j][k]==0){
                    result=-1;
                }
            }
        }
    }
    cout<<result;
    return 0;
}
