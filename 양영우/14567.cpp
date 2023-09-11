#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main(){
    int n,m;
    cin>>n>>m;
    int a,b;
    vector<int> adj[1001];
    int deg[1001];
    int tot[1001];

    fill(tot, tot + n+1, 1);

    for(int i=0; i<m; i++){
        cin>>a>>b;
        adj[a].push_back(b);
        deg[b]++;
    }
    queue<int> Q;
    for(int i=0; i<n; i++){
        if(deg[i] == 0){
            Q.push(i);
        }
    }

    while(!Q.empty()){
        int cur = Q.front(); Q.pop();
        for(int i=0; i<adj[cur].size(); i++){
            int nxt = adj[cur][i];
            deg[nxt] --;
            tot[nxt] = max(tot[nxt], tot[cur] + 1);
            if(deg[nxt] == 0){
                Q.push(nxt);
            }
        }
    }

    for(int i=1; i<=n; i++){
        cout<< tot[i]<<" ";
    }

    



        
}


