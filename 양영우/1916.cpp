#include <iostream>
#include <vector>
#include <functional>
#include <queue>

#define X first
#define Y second


using namespace std;

int n,m;
int st,en;
int v,e;
int cost;


const int INF = 1e9;

int d[1005];


vector<pair<int, int> > adj[1005];
priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;




int dijkstra(){
    fill(d, d+n+1, INF);

    d[st] = 0;
    pq.push({d[st], st});

    while(!pq.empty()){
        pair<int,int> cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for(int i=0; i<adj[cur.Y].size(); i++){
            pair<int,int> nxt = adj[cur.Y][i];
            if(d[nxt.Y] > d[cur.Y] + nxt.X){
                d[nxt.Y] = d[cur.Y] + nxt.X;
                pq.push({d[nxt.Y],nxt.Y});
            }
        }

    }

    return d[en];

}





int main(){
    cin>>n>>m;

    


    for(int i=0; i<m; i++){
        cin>>v>>e>>cost;
        adj[v].push_back({cost,e});
    }


    cin>>st>>en;

    cout<< dijkstra();



}