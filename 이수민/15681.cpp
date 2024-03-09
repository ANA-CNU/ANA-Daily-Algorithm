#include <bits/stdc++.h>
using namespace std;
int n,r,q,u,v;
vector<int> vec[100001];
int check[100001];
int dp[100001];
int dfs(int index) {
    if(dp[index]) return dp[index];
    if(check[index]) return 0;

    check[index] = 1;
    int sum = 0;
    for(int i=0; i<vec[index].size(); i++) {
        sum += dfs(vec[index][i]);
    }
    return dp[index] = sum + 1;
}

int main()
{
    scanf("%d %d %d",&n, &r, &q);
    for(int i=0; i<n-1; i++) {
        scanf("%d %d",&u, &v);
        vec[u].push_back(v);
        vec[v].push_back(u);
    }
    dfs(r);
    for(int i=0; i<q; i++) {
        scanf("%d",&u);
        printf("%d\n",dp[u]);
    }
    return 0;
}
