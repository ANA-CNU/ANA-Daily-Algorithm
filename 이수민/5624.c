#include <stdio.h>
#include <stdlib.h>
int n,arr[5001],dp[400001],cnt;
int main()
{
    scanf("%d",&n);
    for(int i=0; i<n; i++) {
        scanf("%d",&arr[i]);
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<i; j++) {
            if(dp[arr[i] - arr[j] + 200000]) {
                cnt++;
                break;
            }
        }

        for(int j=0; j<=i; j++) {
            dp[arr[i] + arr[j] + 200000] = 1;
        }
    }
    printf("%d",cnt);
    return 0;
}
