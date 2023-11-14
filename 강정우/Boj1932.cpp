#include <iostream>
#include <vector>
using namespace std;
vector<vector<int>>v;
int n;
int dp(){
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<i+1;j++){
            v[i][j]+=max(v[i+1][j],v[i+1][j+1]);
        }
    }
    return v[0][0];
}
int main(){
    cin>>n;
    v.resize(n);
    for(int i=0;i<n;i++){
        for(int j=0;j<i+1;j++){
            int a;
            cin>>a;
            v[i].push_back(a);
        }
    }
    cout<<dp();
}
