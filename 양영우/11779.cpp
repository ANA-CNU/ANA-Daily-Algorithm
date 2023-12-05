#include <iostream>
#include <queue>
#include <vector>
#include <functional>
#include <algorithm>
#define X first
#define Y second


using namespace std;


const int INF = 1e9;



int n,m;

int st, en;

int v,e,cost;

vector<pair<int,int> > adj[1001];

priority_queue<pair<int,int> , vector<pair<int, int> >, greater<pair<int, int> > > pq;

int d[1001];


int path[1001];







int main(){
    ios_base :: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin>>n;
    cin>>m;


    while(m--){
        cin>>v>>e>>cost;
        adj[v].push_back({cost,e});
    }



    cin>>st>>en;


    fill(d, d + n + 1, INF);

    d[st] = 0;

    pq.push({d[st], st});


    while(!pq.empty()){
        pair<int,int> cur = pq.top(); pq.pop();
        if(d[cur.Y] != cur.X) continue;
        for(int i=0; i<adj[cur.Y].size(); i++){
            pair<int,int> nxt = adj[cur.Y][i];
            if(d[nxt.Y] <= d[cur.Y] + nxt.X) continue;
            d[nxt.Y] = d[cur.Y] + nxt.X;
            pq.push({d[nxt.Y], nxt.Y});
            path[nxt.Y] = cur.Y;
        }
    }

    int a = en;

    vector<int> optimal_way;

    

    
    while( a!= st ){
        optimal_way.push_back(a);
        a = path[a];
    }

    optimal_way.push_back(a);


    reverse(optimal_way.begin(),optimal_way.end());



    cout<<d[en]<<'\n';
    cout<<optimal_way.size()<<'\n';

    
    for(int i=0; i<optimal_way.size(); i++){
        cout<<optimal_way[i]<<" ";
    }





}