#include <stdio.h>
#include <stdlib.h>
int c;
int n[5001];
int m[5001];
int dp[5001][10001];
double p;
int main()
{
    for(;;) {
        scanf("%d %lf",&c, &p);
        if(c == 0 && p == 0.00) break;

        int price = (int)(p * 100 + 0.5);

        for(int i=1; i<=c; i++) {
            scanf("%d %lf",&n[i], &p);
            m[i] = (int)(p * 100 + 0.5);
        }

        for(int i=1; i<=c; i++) for(int j=1; j<=10000; j++) dp[i][j] = 0;

        for(int i=1; i<=c; i++) {
            for(int j=1; j<=10000; j++) {
                if(m[i] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = dp[i][j-m[i]] + n[i];
                    dp[i][j] = dp[i][j] < dp[i-1][j] ? dp[i-1][j] : dp[i][j];
                    dp[i][j] = dp[i][j] < dp[i-1][j-m[i]] + n[i] ? dp[i-1][j-m[i]] + n[i] : dp[i][j];
                }
            }
        }
        printf("%d\n",dp[c][price]);
    }
    return 0;
}
