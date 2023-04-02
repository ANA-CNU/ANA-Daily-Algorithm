#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n, k;

    scanf("%d %d", &n, &k);

    int *coins = malloc(n * sizeof(*coins));

    for (int i = 0; i < n; i++) scanf("%d", &coins[i]);

    int *dp = calloc((k + 1), sizeof(*dp));

    dp[0] = 1;

    /*
        DP Table Visualization

        +-----+----+----+----+----+----+----+----+----+----+----+----+
        | C\S | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10 |
        +-----+----+----+----+----+----+----+----+----+----+----+----+
        |   1 |  0 |  1 |  1 |  1 |  1 |  1 |  1 |  1 |  1 |  1 |  1 |
        |   2 |  0 |  0 |  1 |  1 |  2 |  2 |  3 |  3 |  4 |  4 |  5 |
        |   5 |  0 |  0 |  0 |  0 |  0 |  1 |  1 |  2 |  2 |  3 |  4 |
        +-----+----+----+----+----+----+----+----+----+----+----+----+
    */
    
    // 각각의 동전 종류에 대하여...
    for (int i = 0; i < n; i++) {
        // `coins[0]`원짜리 동전부터 `coins[i]`원짜리 동전까지만 사용한다.
        for (int j = 1; j <= k; j++) {
            if (j - coins[i] >= 0)
                dp[j] += dp[j - coins[i]];
        }
    }

    printf("%d\n", dp[k]);

    free(dp), free(coins);

    return 0;
}