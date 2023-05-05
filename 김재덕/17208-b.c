#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
 
typedef struct {
    uint16_t x, y;
} Order;

int main(void) {
    uint16_t N, M, K;

    scanf("%hd %hd %hd", &N, &M, &K);

    Order *orders = malloc((N + 1) * sizeof *orders);

    for (int i = 1; i <= N; i++)
        scanf("%hd %hd", &orders[i].x, &orders[i].y);

    uint16_t ***dp = malloc((N + 1) * sizeof(*dp));

    for (int i = 0; i <= N; i++)
        dp[i] = malloc((M + 1) * sizeof(**dp));

    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= M; j++)
            dp[i][j] = calloc((K + 1), sizeof(***dp));

    for (int i = 1; i <= N; i++) {
        for (int m = 1; m <= M; m++) {
            for (int k = 1; k <= K; k++) {
                const uint16_t x = orders[i].x;
                const uint16_t y = orders[i].y;

                if (m - x >= 0 && k - y >= 0)
                    dp[i][m][k] = (dp[i - 1][m][k] > dp[i - 1][m - x][k - y] + 1)
                        ? dp[i - 1][m][k]
                        : dp[i - 1][m - x][k - y] + 1;
                else dp[i][m][k] = dp[i - 1][m][k];
            }
        }
    }

    printf("%hd\n", dp[N][M][K]);

    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= M; j++)
            free(dp[i][j]);

    for (int i = 0; i <= N; i++)
        free(dp[i]);

    free(dp), free(orders);

    return 0;
}