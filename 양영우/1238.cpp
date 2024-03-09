#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define X first
#define Y second


using namespace std;



const int INF = 0x3f3f3f3f;



vector<pair<int,int> > adj[1001]; 



int n,m,x;

int st,en,cost;



int dijkstra(int st, int en){
    int d[1001];
    fill(d, d + n + 1, INF);
    priority_queue<pair<int,int>, vector<pair<int,int> >, greater<pair<int,int> > > pq;
    d[st] = 0;

    pq.push(make_pair(d[st], st)); //(비용,정점)
    

    while(!pq.empty()){
        pair<int,int> cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for(int i=0; i<adj[cur.Y].size(); i++){
            pair<int,int> nxt = adj[cur.Y][i];
            if(d[nxt.Y] > d[cur.Y] + nxt.X){
                d[nxt.Y] = d[cur.Y] + nxt.X;
                pq.push(make_pair(d[nxt.Y], nxt.Y));
            }

        }
    }

    return d[en];


}







int main(){
    cin.tie(0);
    cin>>n>>m>>x;

    for(int i=0; i<m; i++){
        cin>>st>>en>>cost;
        adj[st].push_back(make_pair(cost, en));
    }



    int ans = 0;



    for(int i=1; i<=n; i++){
        ans = max(ans, dijkstra(i,x) + dijkstra(x,i));

    }

    cout<<ans;


}
