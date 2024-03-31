#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int main(){
    int a,b;
    cin>>a>>b;
    vector<int> v;
    v.resize(1000001,1000000);
    v[a]=0;
    queue<int> q;
    q.push(a);
    while(!q.empty()) {
        int now = q.front();
        q.pop();
        int day = v[now];
        if(v[now*2]>day&&now*2<=b*2){
            v[now*2]=day;
            q.push(now*2);
        }
        if(v[now+1]>day+1&&now+1<=b){
            v[now+1]=day+1;
            q.push(now+1);
        }
        if(v[now-1]>day+1&&now-1>=0){
            v[now-1]=day+1;
            q.push(now-1);
        }
    }
    cout<<v[b];
    return 0;
}
