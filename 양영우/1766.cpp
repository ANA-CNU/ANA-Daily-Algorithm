#include <iostream>
#include <queue>
#include <vector>
#include <functional>


using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n,m; 
    cin>>n>>m;
    vector<int> adj[32001];
    int deg[32001] = {0};

    int a,b;

    for(int i=0; i<m; i++){
        cin>>a>>b;
        adj[a].push_back(b);
        deg[b]++;
    }
    priority_queue<int, vector<int>, greater<int> > pq;

    for(int i=1; i<=n; i++){
        if(deg[i] == 0){
            pq.push(i);
        }
    }



    while(!pq.empty()){
        int cur = pq.top(); pq.pop();
        cout<<cur<<" ";
        for(int i=0; i<adj[cur].size(); i++){
            int nxt = adj[cur][i];
            deg[nxt]--;
            if(deg[nxt] == 0){
                pq.push(nxt);
            }
        }

    }




    

}
