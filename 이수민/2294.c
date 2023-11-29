#include <stdio.h>
#include <stdlib.h>
int n,m;
int arr[101];
int dp[100001];
int f(int x) {

    if(x <= 0) return 987654321;
    if(dp[x]) return dp[x];
    int min = 987654321;
    for(int i=0; i<n; i++) {
        int y = f(x - arr[i]);
        min = min > y ? y : min;
    }
    return dp[x] = min + 1;
}
int main()
{
    scanf("%d %d",&n,&m);
    for(int i=0; i<n; i++) {
        scanf("%d",&arr[i]);
        dp[arr[i]] = 1;
    }
    int k = f(m);
    if(k == 987654321 + 1) printf("-1");
    else printf("%d",k);
    return 0;
}
