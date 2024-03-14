#include <stdio.h>
#include <stdlib.h>
int n;
int arr[17][17];
int dp[17][65536];
int answer = 987654321;
int f(int s, int c, int b) {
    if(b == (1<<n)-1) {
        if(arr[c][s] == 0) return 987654321;
        return arr[c][s];
    }

    if(dp[c][b] != -1) return dp[c][b];
    dp[c][b] = 987654321;
    for(int i=0; i<n; i++) {
        if(arr[c][i] == 0) continue;
        if(((1<<i) & b) == 0) {
            int k = f(s, i, b|(1<<i));
            dp[c][b] = dp[c][b] > arr[c][i] + k ? arr[c][i] + k : dp[c][b];
        }
    }
    return dp[c][b];
}
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            scanf("%d",&arr[i][j]);
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=1; j<=65535; j++) {
            dp[i][j] = -1;
        }
    }
    printf("%d", f(0, 0, 1));

    return 0;
}
