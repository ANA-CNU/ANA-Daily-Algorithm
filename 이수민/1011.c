#include <stdio.h>
#include <stdlib.h>
long long int dp[100001];
long long int s,x,y,t,cnt;
int main()
{
    s = 2;
    dp[1] = 1;
    dp[2] = 2;
    for(int i=3; i<=100000; i++) {
        if(cnt == 2) {
            s++;
            cnt = 0;
        }
        dp[i] = dp[i-1] + s;
        cnt++;
    }
    for(scanf("%lld",&t);t--;) {
        scanf("%lld %lld",&x,&y);
        x = y-x;
        for(int i=1; i<=100000; i++) {
            if(dp[i] < x) continue;
            else {
                printf("%d\n",i);
                break;
            }
        }

    }
    return 0;
}
