#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int next;
    int dis;
}st;
vector<st> v[2001];
struct compare {
    bool operator()(st a, st b) {
        return a.dis > b.dis;
    }
};
void f(int start, int dis[2001]) {

    priority_queue<st, vector<st>, compare> pq;
    pq.push({start, 0});
    dis[start] = 0;

    while(!pq.empty()) {
        st x = pq.top();
        pq.pop();

        if(dis[x.next] < x.dis) continue;

        int x_size = v[x.next].size();
        for(int i=0; i<x_size; i++) {
            st y = v[x.next][i];
            if(dis[y.next] > x.dis + y.dis) {
                dis[y.next] = x.dis + y.dis;
                pq.push({y.next, x.dis+y.dis});
            }
        }
    }

}
int main()
{
    int T,n,m,t,s,g,h,a,b,d,x;
    int S[2001], G[2001], H[2001];
    for(scanf("%d",&T);T--;) {
        scanf("%d %d %d",&n,&m,&t);
        scanf("%d %d %d",&s,&g,&h);

        for(int i=1; i<=n; i++) {
            S[i] = 987654321;
            G[i] = 987654321;
            H[i] = 987654321;
            v[i].clear();
        }
        for(int i=0; i<m; i++) {
            scanf("%d %d %d",&a,&b,&d);
            v[a].push_back({b, d});
            v[b].push_back({a, d});
        }
        f(s, S);
        f(g, G);
        f(h, H);
        vector<int> answer;
        for(int i=0; i<t; i++) {
            scanf("%d",&x);
            if((S[x] == S[g] + G[h] + H[x]) || (S[x] == S[h] + H[g] + G[x])) answer.push_back(x);
        }
        sort(answer.begin(), answer.end());
        for(int i=0; i<answer.size(); i++) printf("%d ",answer[i]);
        printf("\n");
    }
    return 0;
}
