#include <bits/stdc++.h>
using namespace std;
int parent[1001];
int n;
typedef struct {
    char c;
    int f;
    int t;
}st;
struct bcp {
    bool operator()(st a, st b) {
        return a.c > b.c;
    }
};
struct rcmp {
    bool operator()(st a, st b) {
        return a.c < b.c;
    }
};
int get(int a) {
    if(parent[a] == a) return a;
    return parent[a] = get(parent[a]);
}
void add(int a, int b) {
    a = get(a);
    b = get(b);
    if(a < b) parent[b] = a;
    else parent[a] = b;
}
int isEq(int a, int b) {
    a = get(a);
    b = get(b);
    if(a == b) return 1;
    return 0;
}
int isSt() {
    for(int i=1; i<=n; i++) {
        if(get(i) != 1) return 0;
    }
    return 1;
}
priority_queue<st, vector<st>, bcp> bpq;
priority_queue<st, vector<st>, rcmp> rpq;
int main()
{
    int m,q,f,t,bmin,bmax;
    char c;
    for(;;) {
        scanf("%d %d %d",&n, &m, &q);
        if(n == 0) break;

        for(int i=1; i<=n; i++) parent[i] = i;

        for(int i=0; i<m; i++) {
            scanf(" %c %d %d",&c, &f, &t);
            bpq.push({c, f, t});
            rpq.push({c, f, t});
        }
        bmin = bmax = 0;
        while(!bpq.empty()) {
            st k = bpq.top();
            bpq.pop();

            if(!isEq(k.f, k.t)) {
                if(k.c == 'B') {
                    bmax++;
                }
                add(k.f, k.t);
            }
        }

        for(int i=1; i<=n; i++) parent[i] = i;
        while(!rpq.empty()) {
            st k = rpq.top();
            rpq.pop();

            if(!isEq(k.f, k.t)) {
                if(k.c == 'B') {
                    bmin++;
                }
                add(k.f, k.t);
            }
        }
        if(bmin <= q && q <= bmax) printf("1\n");
        else printf("0\n");
    }
    return 0;
}
