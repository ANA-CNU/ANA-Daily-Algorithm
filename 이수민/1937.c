#include <stdio.h>
#include <stdlib.h>
int arr[501][501];
int dp[501][501];
int n;
int dfs(int x, int y) {
    if(x < 1 || x > n || y < 1 || y > n) return 0;
    if(dp[x][y]) return dp[x][y];

    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};
    int m = 0;
    dp[x][y] = 1;

    for(int i=0; i<4; i++) {
        int xx = x+dx[i];
        int yy = y+dy[i];
        if(arr[x][y] < arr[xx][yy]) {
            int k = dfs(xx, yy);
            m = m < k ? k : m;
        }
    }
    return dp[x][y] += m;
}
int main()
{
    int max=0;
    scanf("%d",&n);
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            scanf("%d",&arr[i][j]);
        }
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(!dp[i][j]) dfs(i, j);
            max = max < dp[i][j] ? dp[i][j] : max;
        }
    }
    printf("%d",max);
    return 0;
}
