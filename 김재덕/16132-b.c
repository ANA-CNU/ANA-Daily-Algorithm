#include <stdio.h>
#include <stdlib.h>

int main(void) {
    long long int n;
    
    scanf("%lld", &n);

    // 먼저, 모든 원소의 합을 확인한다.
    long long int sum = (n * (n + 1)) / 2LL;

    // 모든 원소의 합을 정확히 반으로 나눌 수 없는 경우...?
    if ((sum % 2) != 0LL) {
        puts("0");
    } else {
        sum /= 2LL;

        // 0부터 `n`까지의 수
        long long int **dp = malloc((n + 1) * sizeof(*dp));

        // 그리고 0부터 `sum`까지의 각 집합의 모든 원소의 합
        for (int i = 0; i < n + 1; i++)
            dp[i] = calloc((sum + 1), sizeof(**dp));

        dp[0][0] = 1LL;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                // 현재 원소를 제외하거나 포함하거나 둘 중 하나
                dp[i][j] = dp[i - 1][j] 
                    + ((j - i >= 0) ? dp[i - 1][j - i] : 0);
            }
        }

        printf("%lld\n", dp[n - 1][sum]);

        for (int i = 0; i < n + 1; i++) free(dp[i]);

        free(dp);
    }

    return 0;
}