#include <stdio.h>
#include <stdlib.h>
int dp[10001] = {0, 1, 2, 3};
int n,m;
int main()
{
    for(int i=4; i<=10000; i++) dp[i] = 1+(i/2)+dp[i-3];
    for(scanf("%d",&n);n--;){
        scanf("%d",&m);
        printf("%d\n",dp[m]);
    }
    return 0;
}
