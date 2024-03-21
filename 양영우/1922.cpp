#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> p(100001,-1);


int find(int k){
    if(p[k] < 0) return k;
    return p[k] = find(p[k]);
}

bool is_diff_group(int a, int b){
    a = find(a); b = find(b);

    if(a == b) return 0;
    if(p[a] == p[b]) p[a]--;
    if(p[a] < p[b]) p[a] = b;
    else  p[b] = a;

    return 1;

}

int a,b,cost;


tuple<int,int,int> edge[100001];



int n,m;

int main(){
    cin>>n;
    cin>>m;


    for(int i=0; i<m; i++){
        cin>>a>>b>>cost;
        edge[i] = {cost,a,b};
    }

    sort(edge, edge + m);

    int cnt = 0;
    int ans = 0;

    for(int i=0; i<m; i++){
        int a,b,cost;
        tie(cost, a, b) = edge[i];
        if(!is_diff_group(a,b)) continue;
        cnt++;
        ans += cost;
        if(cnt == n-1) break;
    }


    cout<<ans;



}