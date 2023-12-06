#include <bits/stdc++.h>
using namespace std;
int n,m,a,b;
int answer;
int check[2001];
vector<int> v[2001];
void f(int index, int cnt) {
    if(answer == 1) return;
    if(cnt == 5) {
        answer = 1;
        return;
    }

    for(int i=0; i<v[index].size(); i++) {
        if(!check[v[index][i]]) {
            check[v[index][i]] = 1;
            f(v[index][i], cnt+1);
            check[v[index][i]] = 0;
        }
    }
}
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0; i<m; i++) {
        scanf("%d %d",&a,&b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    for(int i=0; i<n; i++) {
        if(v[i].size() != 0) {
            check[i] = 1;
            f(i, 1);
            check[i] = 0;
        }
    }
    printf("%d",answer);
    return 0;
}
