#include <bits/stdc++.h>
using namespace std;
typedef struct {
    int a;
    int b;
    int c;
}st;
int n,arr[3];
int dp[61][61][61];
int attack[6][3] = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,9,3},{1,3,9}};
queue<st> q;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d",&arr[i]);
    }
    q.push({arr[0], arr[1], arr[2]});

    while(!q.empty()) {
        st x = q.front();
        q.pop();
        if(x.a == 0 && x.b == 0 && x.c == 0) break;
        for(int i=0; i<6; i++) {
            int a = (x.a - attack[i][0] >= 0) ? x.a - attack[i][0] : 0;
            int b = (x.b - attack[i][1] >= 0) ? x.b - attack[i][1] : 0;
            int c = (x.c - attack[i][2] >= 0) ? x.c - attack[i][2] : 0;
            if(dp[a][b][c] == 0) {
                q.push({a, b, c});
                dp[a][b][c] = dp[x.a][x.b][x.c] + 1;
            }
        }
    }
    printf("%d",dp[0][0][0]);
    return 0;
}
