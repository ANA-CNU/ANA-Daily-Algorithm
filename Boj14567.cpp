#include <iostream>
#include <queue>
#include <vector>
using namespace std;
int main(){
    int n,m;
    int l=0;
    cin>>n>>m;
    vector<int>v;
    vector<vector<int>>map;
    int result[n+1];
    queue<int>q;
    bool visited[n+1];
    int arr[n+1];
    for(int i=0;i<=n;i++){
        arr[i]=0;
        visited[i]=false;
        map.push_back(vector<int>{});
    }
    for(int i=0;i<m;i++){
        int x,y;
        cin>>x>>y;
        arr[y]++;
        map[x].push_back(y);
    }
    q.push(0);
    int cnt=1;
    while (!q.empty()){
        int x=q.front();
        cnt--;
        q.pop();
        for(int i=0;i<map[x].size();i++){
            arr[map[x][i]]--;
        }
        if(cnt==0){
            l++;
            for(int i=1;i<=n;i++){
                if(arr[i]==0&&!visited[i]){
                    cnt++;
                    q.push(i);
                    result[i]=l;
                    visited[i]= true;
                }
            }
        }
    }
    for(int i=1;i<=n;i++)
        cout<<result[i]<<" ";
    return 0;
}
