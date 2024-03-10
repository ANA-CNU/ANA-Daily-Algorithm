#include <bits/stdc++.h>
using namespace std;
int n,a,b;
int dp[10001][2];
int value[10001];
vector<int> v[10001];
vector<int> answer;
void dfs(int index, int parent) {

    dp[index][0] = 0;
    dp[index][1] = value[index];

    int t = v[index].size();
    for(int i=0; i<t; i++) {
        int k = v[index][i];
        if(k != parent) {
            dfs(k, index);
            dp[index][0] += dp[k][0] < dp[k][1] ? dp[k][1] : dp[k][0];
            dp[index][1] += dp[k][0];
        }
    }
}
void f(int index, int parent, int parent_check) {

    if(parent_check == 0) {
        if(dp[index][0] < dp[index][1]) {
            answer.push_back(index);
            int t = v[index].size();
            for(int i=0; i<t; i++) {
                int k = v[index][i];
                if(k != parent) {
                    f(k, index, 1);
                }
            }
        }
        else {
            int t = v[index].size();
            for(int i=0; i<t; i++) {
                int k = v[index][i];
                if(k != parent) {
                    f(k, index, 0);
                }
            }
        }
    }
    else {
        int t = v[index].size();
        for(int i=0; i<t; i++) {
            int k = v[index][i];
            if(k != parent) {
                f(k, index, 0);
            }
        }
    }
}
int main()
{
    scanf("%d",&n);
    for(int i=1; i<=n; i++) scanf("%d",&value[i]);
    for(int i=0; i<n-1; i++) {
        scanf("%d %d",&a,&b);
        v[a].push_back(b);
        v[b].push_back(a);
    }
    dfs(1, -1);
    printf("%d\n",dp[1][0] < dp[1][1] ? dp[1][1] : dp[1][0]);
    f(1, -1, 0);
    sort(answer.begin(), answer.end());
    for(int i=0; i<answer.size(); i++) printf("%d ",answer[i]);
    return 0;
}
