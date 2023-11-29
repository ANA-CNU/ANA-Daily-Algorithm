#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int next;
    int dis;
}st;
struct compare {
    bool operator()(st a, st b) {
        return a.dis > b.dis;
    }
};
priority_queue<st, vector<st>, compare> pq;
vector<st> v[50001];
int dis[50001];
int main()
{
    int n,m,a,b,c;
    scanf("%d %d",&n,&m);
    for(int i=1; i<=n; i++) dis[i] = 987654321;
    for(int i=0; i<m; i++) {
        scanf("%d %d %d",&a,&b,&c);
        v[a].push_back({b, c});
        v[b].push_back({a, c});
    }
    pq.push({1, 0});
    dis[1] = 0;
    while(!pq.empty()) {
        st x = pq.top();
        pq.pop();

        if(dis[x.next] < x.dis) continue;
        for(int i=0; i<v[x.next].size(); i++) {
            int next = v[x.next][i].next;
            int next_dis = x.dis + v[x.next][i].dis;
            if(dis[next] > next_dis) {
                dis[next] = next_dis;
                pq.push({next, next_dis});
            }
        }
    }
    printf("%d",dis[n]);
    return 0;
}
