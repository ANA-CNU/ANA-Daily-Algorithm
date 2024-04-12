#include <iostream>
#include <vector>
#include <queue>
#define max 100001
using namespace std;
bool visit[max];
int result[max];
vector<int>vec[max];
int main(){
    int n;
    cin>>n;
    for(int i=0;i<n-1;i++){
        int a,b;
        cin>>a>>b;
        vec[a].push_back(b);
        vec[b].push_back(a);
    }
    queue<int>q;
    q.push(1);
    visit[1]= true;
    while(!q.empty()){
        int k=q.front();
        q.pop();
        for(int i=0;i<vec[k].size();i++){
            int l=vec[k][i];
            if(!visit[l]){
                result[l]=k;
                visit[l]= true;
                q.push(l);
            }
        }
    }
    for(int i=2;i<=n;i++)
        cout<<result[i]<<"\n";
}
