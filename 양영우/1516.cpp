


#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int main(){
    int n, value, to;
    vector<int> adj[501];
    int time[501];
    int deg[501];
    int complete[501];

    cin>>n;

    priority_queue<int, vector<int>, greater<int> > pq;

    for(int i=1; i<=n; i++){
        cin>>value;
        complete[i] = time[i] = value;
        while(true){
            cin>>to;
            if(to == -1) break;
            adj[to].push_back(i);
            deg[i]++;
        }
    }

    for(int i=1; i<=n; i++){
        if(deg[i] == 0){
            pq.push(i);
            complete[i]=time[i];
        }
    }

    while(!pq.empty()){
        int cur = pq.top(); pq.pop();
        for(int i=0; i<adj[cur].size(); i++){
            int nxt = adj[cur][i];
            complete[nxt] = max(complete[cur]+time[nxt],complete[nxt]);
            
            deg[nxt]--;
            
            if(deg[nxt]==0)
                pq.push(nxt);
                
            
           
         }
     }

     for(int i=1;i<=n;i++)
         cout<<complete[i]<<'\n';

}


